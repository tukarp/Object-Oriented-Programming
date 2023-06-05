package com.example.client;

import javafx.scene.control.TextInputDialog;
import com.company.chatclient.ServerThread;
import javafx.application.Application;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.Optional;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
