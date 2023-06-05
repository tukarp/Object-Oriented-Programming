package com.example.client;

import com.company.chatclient.ClientReceiver;
import javafx.application.Platform;
import java.util.Arrays;

public class ClientGUIReceiver implements ClientReceiver {
    MainContainer mainController = null;

    public void setMainController(MainContainer mainController) {
        this.mainController = mainController;
    }

    @Override
    public void receiveBroadcast(String sender, String message) {
        mainController.showBroadcast(sender, message);
    }

    @Override
    public void receiveWhisper(String s, String s1) {}

    @Override
    public void receiveFile(String sender, long fileSize, String fileName) {}

    @Override
    public void receiveLoginBroadcast(String sender) {
        Platform.runLater(()->mainController.addToClients(sender));
    }

    @Override
    public void receiveLogoutBroadcast(String sender) {
        Platform.runLater(()->mainController.removeFromClients(sender));
    }

    @Override
    public void receiveOnline(String[] strings) {
        mainController.populateOnlineList(Arrays.stream(strings).toList());
    }

    @Override
    public void receiveFileProgress(int progress) {
        mainController.setFileProgress(progress);
    }
}
