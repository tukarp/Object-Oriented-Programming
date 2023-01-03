package com.example.circleapp;

import com.example.circleapp.client.ServerThread;
import com.example.circleapp.server.Server;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("app-view.fxml"));
        Server server = new Server();
        ServerThread serverThread = new ServerThread();
        fxmlLoader.setControllerFactory(controller -> new Controller(server, serverThread));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}