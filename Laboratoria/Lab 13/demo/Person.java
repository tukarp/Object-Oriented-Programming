package com.example.demo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Person {
    private int id;
    private String firstName, lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }

    public Person(int id, String first_name, String last_name) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public static List<Person> selectAll() throws SQLException {
        Statement statement = DatabaseConnection.getConnection().createStatement();
        return resultSetToList(statement.executeQuery("SELECT * FROM person"));
    }

    public static List<Person> selectByLastName(String substring) throws SQLException {
        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM person WHERE last_name = ?;");
        statement.setString(1, substring);
        statement.execute();
        return resultSetToList(statement.getResultSet());
    }

    public static List<Person> selectByLastNameStartsWith(String substring) throws SQLException {
        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM person WHERE last_name LIKE ?;");
        statement.setString(1, substring + "%");
        statement.executeQuery();
        return resultSetToList(statement.getResultSet());
    }

    private static List<Person> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Person> result = new LinkedList<>();
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            Person person = new Person(id, firstName, lastName);
            result.add(person);
        }
        return result;
    }

    public static void insertPerson(String firstName,String lastName) throws SQLException {
        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("INSERT INTO person(first_name, last_name) VALUES (?, ?);");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.executeUpdate();
    }

    public static int insertPersonReturningId(String firstName,String lastName) throws SQLException {
        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("INSERT INTO person(first_name, last_name) VALUES (?, ?);");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
