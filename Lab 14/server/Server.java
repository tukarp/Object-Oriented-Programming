package com.example.circleapp.server;

import com.example.circleapp.DatabaseConnection;
import com.example.circleapp.Dot;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
    private ServerSocket serverSocket;
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private int port;
    private List<ClientThread> clients = new ArrayList<>();

    public void run(){
        try {
            this.serverSocket = new ServerSocket(port);
            Socket clientSocket;

            DatabaseConnection.connect();

            System.out.println("Server started");
            while(true){
                clientSocket = serverSocket.accept();
                ClientThread thread = new ClientThread(clientSocket, this);
                System.out.println("Client connected");
                clients.add(thread);
                thread.start();
                getSavedDots().stream().forEach(dot -> thread.send(dot.toMessage()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void broadcast(String message) {
        clients.forEach(clientThread -> clientThread.send(message));
        saveDot(Dot.fromMessage(message));

    }

    /*

    CREATE TABLE dot (
        id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        x INTEGER NOT NULL,
        y INTEGER NOT NULL,
        color TEXT NOT NULL,
        radius INTEGER NOT NULL,
    );

     */

    public void saveDot(Dot dp) {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection()
                    .prepareStatement("INSERT INTO dot(x, y, color, radius) VALUES (?, ?, ?, ?);");
            statement.setInt(1, dp.x());
            statement.setInt(2, dp.y());
            statement.setString(3, dp.color());
            statement.setInt(4, dp.radius());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Dot> getSavedDots() {
        List<Dot> dots = new ArrayList<>();
        try {
            PreparedStatement statement = DatabaseConnection.getConnection()
                    .prepareStatement("SELECT * FROM dot");
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next()) {
                int x = resultSet.getInt("x");
                int y = resultSet.getInt("y");
                String color = resultSet.getString("color");
                int radius = resultSet.getInt("radius");
                dots.add(new Dot(x, y, color, radius));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dots;
    }
}
