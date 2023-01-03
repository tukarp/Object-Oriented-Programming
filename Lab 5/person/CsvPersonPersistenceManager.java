package com.company.person;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class CsvPersonPersistenceManager implements PersonPersistenceManager{
    @Override
    public Person[] load(String path) {
        List<Person> result = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while(null != (line = reader.readLine())) {
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                LocalDate birth = Person.parseDate(tokenizer.nextToken());
                LocalDate death = null;
                if(tokenizer.hasMoreTokens())
                    death = Person.parseDate(tokenizer.nextToken());
                result.add(new Person(name, birth, death));
            }
            reader.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            e.printStackTrace();
        }

        final Person[] people = result.toArray(new Person[0]);
        return people;
    }

    @Override
    public void save(String path, Person[] people) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(Person person : people) {
                writer.write(person.getName());
                writer.write(';'+Person.parseDate(person.getBirth()));
                writer.write(";"+(person.getDeath() == null? "" : Person.parseDate(person.getDeath())));
                writer.newLine();
            }
            writer.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    public void sortCsv(String path) {
        Person[] people = this.load(path);// Person.fromCsv(path);
        //Arrays.sort(people,Comparator.comparing(Person::getBirth));
        Arrays.sort(people, new Comparator<Person>(){
            public int compare(Person p1, Person p2) {
                return p1.getBirth().compareTo(p2.getBirth());
            }
        });
        this.save(path, people);
    }
}
