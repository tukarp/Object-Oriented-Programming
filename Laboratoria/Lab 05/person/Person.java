package com.company.person;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class Person implements Serializable{
    private String name;
    private LocalDate birth, death;

    List<Person> parents = new ArrayList<>();
    List<Person> children = new ArrayList<>();

    Person(String name, LocalDate birth, LocalDate death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
    }

    public String getName() {
        return name;
    }
    public LocalDate getDeath() {
        return death;
    }
    public LocalDate getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        String str="Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                ", parents={";
        for(var parent : parents )
            str += parent.name + ", ";
        str += "} children={";
        for(var child : children )
            str += child.name + ", ";
        str+ = "}}";

        return str;
    }

    static LocalDate parseDate(String str) throws DateTimeParseException, NullPointerException {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    static String parseDate(LocalDate date)  {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
