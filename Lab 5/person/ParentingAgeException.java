package com.company.person;

public class ParentingAgeException extends RuntimeException {
    private static int minAge = 10;
    private static int maxAge = 100;
    private String pathParent;
    private String pathChild;
    public ParentingAgeException(String pathParent, String pathChild){
        this.pathParent=pathParent;
        this.pathChild=pathChild;
    }

    @Override
    public String toString() {
        return "ParentingAgeException{" +
                "pathParent='" + pathParent + '\'' +
                ", pathChild='" + pathChild + '\'' +
                '}';
    }

    public String getPathParent() {
        return pathParent;
    }

    public String getPathChild() {
        return pathChild;
    }

    public static boolean checkAge(int age) {
        return minAge < age && age < maxAge;
    }

    public static void setMinAge(int minAge) {
        ParentingAgeException.minAge = minAge;
    }

    public static void setMaxAge(int maxAge) {
        ParentingAgeException.maxAge = maxAge;
    }
}
