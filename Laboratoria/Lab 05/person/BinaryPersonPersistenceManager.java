package com.company.person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryPersonPersistenceManager implements PersonPersistenceManager{
    @Override
    public Person[] load(String path) {
        List<Person> people = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);

            Object obj = null;
            while(!(obj = in.readObject()).equals(null)){
                if(obj instanceof Person){
                    people.add((Person) obj);
                }
            }

        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people.toArray(new Person[0]);
    }

    @Override
    public void save(String path, Person[] people) {
        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);
            for(var person:people)
                out.writeObject(person);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
