package com.company;

import com.company.person.*;

public class Main {

    public static void main(String[] args) {
        PersonPersistenceManager manager = new DirectoryPersonPersistenceManager();
        try {
            Person[] people = manager.load("test_dzieci_rodzice");
            for(Person person : people) {
                System.out.println(person);
            }
        }
        catch (AmbigiousPersonException | ParentingAgeException |ParentChildInconsistencyException e) {
            e.printStackTrace();
        }
    }
}
