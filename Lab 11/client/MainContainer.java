package com.example.lb11_client;

import com.company.chatclient.ServerThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class MainContainer {
    ServerThread serverThread;
    ClientGUIReceiver receiver;

    public MainContainer(ServerThread serverThread, ClientGUIReceiver receiver) {
        this.serverThread = serverThread;
        this.receiver = receiver;
        this.receiver.setMainController(this);
    }

    @FXML
    private TextField inputField;

    @FXML
    private TextArea outputArea;

    @FXML
    private Button sendButton;

    @FXML
    private ListView clientList;

    @FXML
    private GridPane mainPane;

    @FXML
    private ProgressBar fileProgressBar;

    @FXML
    protected void onSendButtonClick() {
        send();
    }

    @FXML
    public void onInputEnter(ActionEvent actionEvent){
        send();
    }

    private void send() {
        String text = inputField.getText();
        serverThread.broadcast(text);
        //inputField.clear();
    }

    @FXML
    private void onSendFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow());
        if (file != null) {
            serverThread.sendFile(clientList.getSelectionModel().getSelectedItem().toString(), file.getAbsolutePath());
        }
    }

    public void populateOnlineList(List<String> clientNames) {
        clientList.getItems().clear();
        clientNames.stream()
                .forEach(name -> clientList.getItems().add(name));
    }

    public void showBroadcast(String sender, String message) {
        outputArea.appendText("\n"+sender+": "+message);
        outputArea.setScrollTop(Double.MAX_VALUE);
    }

    public void addToClients(String clientName) {
        clientList.getItems().add(clientName);
    }

    public void removeFromClients(String clientName) {
        clientList.getItems().remove(clientName);
    }

    public void setFileProgress(int progress) {
        fileProgressBar.setProgress(progress/100.);
    }
}