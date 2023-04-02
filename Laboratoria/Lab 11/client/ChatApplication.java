package com.example.lb11_client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import com.company.chatclient.ServerThread;
public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ServerThread serverThread = new ServerThread("localhost", 5000);

        ClientGUIReceiver receiver = new ClientGUIReceiver();
        serverThread.setReceiver(receiver);
        serverThread.setDaemon(true);
        serverThread.start();

        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(controllerClass -> new MainContainer(serverThread, receiver));

        Scene scene = new Scene(fxmlLoader.load(), 640, 480);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Login: ");
//        String login = reader.readLine();

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Login");
        dialog.setHeaderText("Login");
        dialog.setContentText("Please enter your name:");

        Optional<String> result = dialog.showAndWait();
        String login = null;
        if (result.isPresent())  {
            login = result.get();

            serverThread.login(login);

            stage.setTitle("Chat - " + login);
            stage.setScene(scene);
            stage.show();
        }
    }
    public static void main(String[] args) throws IOException {
        launch();
    }
}