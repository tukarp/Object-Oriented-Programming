package com.company.person;

public interface PersonPersistenceManager {
    Person[] load(String path);
    void save(String path, Person people[]);
}
