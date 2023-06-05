package com.example.circleapp;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseConnection {
    static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Connected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
            System.out.println("Disconnected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
