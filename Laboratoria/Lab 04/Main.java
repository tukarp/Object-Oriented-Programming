package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Zadanie 1
        Person person = Person.fromFile("Lab 4/Zadania/zadanie1.txt");
        System.out.println("Zadanie 1");
        System.out.println(person.toString());

        // Zadanie 2
        Person[] personArr = Person.fromCsv("Lab 4/Zadania/zadanie2.csv");
        System.out.println("Zadanie 2");
        System.out.println(Arrays.deepToString(personArr));

        // Zadanie 3a
        Person.toFile("zadanie3a.txt", person);

        // Zadanie 3b
        Person.toCsv("Lab 4/Zadania/zadanie3b.csv", personArr);

        // Zadanie 3c
        Person.sortCsv("Lab 4/Zadania/zadanie3b.csv");

        // Zadanie 4a
        Person.toDirectory("Lab 4/Zadania/Zadanie4a", personArr);

        // Zadanie 4b
        Person[] parr = Person.fromDirectory("zadanie4a");
        System.out.println("Zadanie 4b");
        for(var p:parr)
            System.out.println(p.toString());

        // Zadanie 5
        Person.toBinaryFile("zadanie5.bin", parr);
        Person[] parrOut = Person.fromBinaryFile("zadanie5.bin");

        System.out.println("---5---");
        for(var p:parr)
            System.out.println(p.toString());
    }
}
