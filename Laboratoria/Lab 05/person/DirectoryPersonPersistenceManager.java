package com.company.person;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DirectoryPersonPersistenceManager implements PersonPersistenceManager{
    private enum FileExpectation{ExpectsDeath, ExpectsParent, ExpectsChild}

    // Zadanie 1
//    @Override
//    public Person[] load(String path) {
//        File[] files = new File(path).listFiles();
//        Person[] result = new Person[files.length];
//        for(int i = 0; i < files.length; i++) {
//            result[i] = Person.fromFile(files[i].getPath());
//        }
//        return result;
//    }
//

    @Override
    public void save(String path, Person[] people) {
        File dir = new File(path);
        if(dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for(var file: files)
                file.delete();
        }
        else {
            try {
                Files.createDirectory(dir.toPath());
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        for(Person person : people) {
            toFile(path + "/" + person.getName() + ".txt", person);
        }
    }

    public static void toFile(String path, Person person) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(person.getName() + "\n");
            writer.write(Person.parseDate(person.getBirth()) + "\n");
            if(person.getDeath() != null) {
                writer.write(Person.parseDate(person.getDeath()) + "\n");
            }
            writer.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    // Zadanie 2
//    @Override
//    public Person[] load(String path) throws AmbigiousPersonException {
//        Map<String, TemporaryPerson> temporaryMap = new HashMap<>();
//
//        File[] files = new File(path).listFiles();
//        for(int i = 0; i < files.length; i++) {
//            TemporaryPerson person = fromFile(files[i].getPath());
//            if(temporaryMap.containsKey(person.getName()))
//                throw new AmbigiousPersonException(person.getPath(), temporaryMap.get(person.getName()).getPath());
//            else
//                temporaryMap.put(person.getName(), person);
//        }
//        return temporaryMap.values().toArray(new Person[0]);
//    }
//
//    private TemporaryPerson fromFile(String path) {
//        BufferedReader reader;
//        String name = null;
//        LocalDate birth = null, death = null;
//        try {
//            reader = new BufferedReader(new FileReader(path));
//            name = reader.readLine();
//            birth = Person.parseDate(reader.readLine());
//            death = Person.parseDate(reader.readLine());
//
//
//        } catch (IOException | NullPointerException e) {
//            //e.printStackTrace();
//        }
//        return new TemporaryPerson(name, birth, death, path);
//    }

    // Zadanie 3
//    private TemporaryPerson fromFile(String path) {
//        Scanner reader;
//        String name = null;
//        List<String> parentNames = new ArrayList<>();
//        LocalDate birth = null, death = null;
//        try {
//            reader = new Scanner(new File(path));
//            name = reader.nextLine();
//            birth = Person.parseDate(reader.nextLine());
//
//            FileExpectation expectation = FileExpectation.ExpectsDeath;
//
//            while(reader.hasNext()) {
//                String line = reader.nextLine();
//                if(line.isEmpty()) continue;
//                switch (expectation) {
//                    case ExpectsDeath:
//                        if(line.equals("Rodzice:"))
//                            expectation = FileExpectation.ExpectsParent;
//                        else
//                            death = Person.parseDate(line);
//                        break;
//                    case ExpectsParent:
//                        //System.out.println(name + " " + line);
//                        parentNames.add(line);
//                        break;
//                }
//            }
//        } catch (NullPointerException | FileNotFoundException e) {
//            //e.printStackTrace();
//        }
//        return new TemporaryPerson(name, birth, death, path, parentNames);
//    }
//    public Person[] load(String path) throws AmbigiousPersonException{
//        Map<String, TemporaryPerson> temporaryMap = new HashMap<>();
//
//        File[] files = new File(path).listFiles();
//        for(int i = 0; i < files.length; i++) {
//            TemporaryPerson person = fromFile(files[i].getPath());
//            if(temporaryMap.containsKey(person.getName()))
//                throw new AmbigiousPersonException(person.getPath(), temporaryMap.get(person.getName()).getPath());
//            else
//                temporaryMap.put(person.getName(), person);
//        }
//        for (Map.Entry<String, TemporaryPerson> pair : temporaryMap.entrySet()) {
//            pair.getValue().convert(temporaryMap);
//        }
//        Collection<TemporaryPerson> values = temporaryMap.values();
//        Person[] people = temporaryMap.values().toArray(new Person[0]);
//        return people;
//    }

    @Override
    public Person[] load(String path) throws AmbigiousPersonException, ParentingAgeException {
        Map<String, TemporaryPerson> temporaryMap = new HashMap<>();

        File[] files = new File(path).listFiles();
        for(int i = 0; i < files.length; i++) {
            TemporaryPerson person = fromFile(files[i].getPath());
            if(temporaryMap.containsKey(person.getName()))
                throw new AmbigiousPersonException(person.getPath(), temporaryMap.get(person.getName()).getPath());
            else
                temporaryMap.put(person.getName(), person);
        }
        for (Map.Entry<String, TemporaryPerson> pair : temporaryMap.entrySet()) {
            pair.getValue().convert(temporaryMap);
        }
        for (Map.Entry<String, TemporaryPerson> pair : temporaryMap.entrySet()) {
            pair.getValue().convertChildren(temporaryMap);
        }
        Collection<TemporaryPerson> values = temporaryMap.values();
        checkParentingAge(values);
        Person[] people = temporaryMap.values().toArray(new Person[0]);
        return people;
    }

    private void checkParentingAge(Collection<TemporaryPerson> people) throws ParentingAgeException{
        for(TemporaryPerson person : people) {
            for(Person parent : person.parents) {
                if(!ParentingAgeException.checkAge(person.getBirth().getYear() - parent.getBirth().getYear()))
                    throw new ParentingAgeException(person.getPath(), ((TemporaryPerson)parent).getPath());
            }
        }
    }


    private TemporaryPerson fromFile(String path) {
        Scanner reader;
        String name = null;
        List<String> parentNames = new ArrayList<>();
        List<String> childrenNames = new ArrayList<>();
        LocalDate birth = null, death = null;
        try {
            reader = new Scanner(new File(path));
            name = reader.nextLine();
            birth = Person.parseDate(reader.nextLine());

            FileExpectation expectation = FileExpectation.ExpectsDeath;

            while(reader.hasNext()) {
                String line = reader.nextLine();
                if(line.isEmpty()) continue;
                switch (expectation) {
                    case ExpectsDeath:
                        if(line.equals("Rodzice:"))
                            expectation = FileExpectation.ExpectsParent;
                        else if (line.equals("Dzieci:"))
                            expectation = FileExpectation.ExpectsChild;
                        else
                            death = Person.parseDate(line);
                        break;
                    case ExpectsParent:
                        //System.out.println(name + " " + line);
                        if (line.equals("Dzieci:"))
                            expectation = FileExpectation.ExpectsChild;
                        else
                            parentNames.add(line);
                        break;
                    case ExpectsChild:
                        childrenNames.add(line);
                        break;
                }
            }
        } catch (NullPointerException | FileNotFoundException e) {
            //e.printStackTrace();
        }
        return new TemporaryPerson(name, birth, death, path, parentNames, childrenNames);
    }
}
