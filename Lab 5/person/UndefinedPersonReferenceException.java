package com.company.person;

public class UndefinedPersonReferenceException  extends RuntimeException{
    String path;
    String name;
    public UndefinedPersonReferenceException(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UndefinedPersonReferenceException{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
