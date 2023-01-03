package com.company;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        DatabaseConnection.connect();
        try {
            System.out.println(Person.insertPersonReturningId("Alicja2", "Makota"));
            System.out.println(Person.selectAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DatabaseConnection.disconnect();
    }
}
