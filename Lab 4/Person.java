package com.company;


import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class Person {
    private String name;
    private LocalDate birth, death;

    private Person(String name, LocalDate birth, LocalDate death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                '}';
    }
    public LocalDate getBirth() {
        return birth;
    }

    //zadanie 1
    public static Person fromFile(String path) {
        String name = null;
        LocalDate birth = null, death = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            name = reader.readLine();
            birth = parseDate(reader.readLine());
            death = parseDate(reader.readLine());
            reader.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            e.printStackTrace();
        }
        return new Person(name, birth, death);
    }

    private static LocalDate parseDate(String str) throws DateTimeParseException, NullPointerException {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    //Zadanie 2
    public static Person[] fromCsv(String path) {
        List<Person> result = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while(null != (line = reader.readLine())) {
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                LocalDate birth = parseDate(tokenizer.nextToken());
                LocalDate death = null;
                if(tokenizer.hasMoreTokens())
                    death = parseDate(tokenizer.nextToken());
                result.add(new Person(name, birth, death));
            }
            reader.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            e.printStackTrace();
        }
        final Person[] people = result.toArray(new Person[0]);
        return people;
    }

    //Zadanie 3a
    public static void toFile(String path, Person person) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(person.name+"\n");
            writer.write(parseDate(person.birth)+"\n");
            if(person.death != null) {
                writer.write(parseDate(person.death)+"\n");
            }
            writer.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    private static String parseDate(LocalDate date)  {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    //Zadanie 3b
    public static void toCsv(String path, Person[] people) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(Person person : people) {
                writer.write(person.name);
                writer.write(';'+parseDate(person.birth));
                writer.write(";"+(person.death == null? "" : parseDate(person.death)));
                writer.newLine();
            }
            writer.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    //Zadanie 3c
    public static void sortCsv(String path) {
        Person[] people = Person.fromCsv(path);
        //Arrays.sort(people,Comparator.comparing(Person::getBirth));
        Arrays.sort(people, new Comparator<Person>(){
            public int compare(Person p1, Person p2) {
                return p1.birth.compareTo(p2.birth);
            }
        });
        Person.toCsv(path, people);
    }

    //Zadanie 4a
    public static void toDirectory(String path, Person people[]) {
        File dir = new File(path);
        if(dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for(var file: files)
                file.delete();
        }
        else {
            try {
                Files.createDirectory(dir.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(Person person : people) {
            Person.toFile(path+"/"+person.name+".txt", person);
        }
    }

    //Zadanie 4b
    public static Person[] fromDirectory(String path) {
        File[] files = new File(path).listFiles();
        Person[] result = new Person[files.length];
        for(int i = 0; i < files.length; i++) {
            result[i] = fromFile(files[i].getPath());
        }
        return result;
    }

    //Zadanie 5
    public static void toBinaryFile(String path, Person people[]) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person[] fromBinaryFile(String path) {
        Person[] result = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream iis = new ObjectInputStream(fis);
            result = (Person[]) iis.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
