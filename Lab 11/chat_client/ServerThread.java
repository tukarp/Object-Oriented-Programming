package com.company.chatclient;

import java.io.*;
import java.net.Socket;
import java.nio.file.Path;

public class ServerThread extends Thread {
    private Socket socket;
    private PrintWriter writer;
    private ClientReceiver receiver = null;

    public void setReceiver(ClientReceiver receiver) {
        this.receiver = receiver;
    }

    public ServerThread(String address, int port) {
        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            writer = new PrintWriter(output, true);
            String message;
            while ((message = reader.readLine()) != null){
                String prefix = message.substring(0,2);
                String postfix = message.substring(2);
                System.out.println(message);
                switch(prefix) {
                    case "BR" -> { //broadcast
                        String[] postfixArr = postfix.split(" ",2);
                        receiver.receiveBroadcast(postfixArr[0], postfixArr[1]);
                    }
                    case "WH" -> { //whisper
                        String[] postfixArr = postfix.split(" ",2);
                        receiver.receiveWhisper(postfixArr[0], postfixArr[1]);
                    }
                    case "FI" -> { //file
                        receiveFile(postfix);
                        //String[] postfixArr = postfix.split(" ",3);
                        //receiver.receiveFile(postfixArr[0], Long.parseLong(postfixArr[1]), postfixArr[2]);
                    }
                    case "LN" -> receiver.receiveLoginBroadcast(postfix);
                    case "LT" -> receiver.receiveLogoutBroadcast(postfix);
                    case "ON" -> receiver.receiveOnline(postfix.split(" "));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(String message){
        writer.println(message);
    }

    public void login(String name) {
        writer.println("LO"+name);
    }

    public void broadcast(String message) {
        writer.println("BR"+message);
    }

    public void whisper(String message) {
        writer.println("WH"+message);
    }

    public void online() {
        writer.println("ON");
    }

    //public void sendFile(String command) {
    public void sendFile(String recipientName, String filePath) {
//        String commandArr[] = command.split(" ");
//        String recipientName = commandArr[0];
//        String filePath = commandArr[1];

        File file = new File(filePath);

        try {
            long fileSize = file.length();
            writer.println("FI"+recipientName+" "+fileSize+" "+file.getName());
            FileInputStream fileIn = new FileInputStream(file);
            DataOutputStream fileOut = new DataOutputStream(socket.getOutputStream());
            byte[] buffer = new byte[64];
            int count;
            long sentSize = 0;

            while ((count = fileIn.read(buffer)) > 0) {
                fileOut.write(buffer,0,count);
                sentSize += count;
                receiver.receiveFileProgress((int)(sentSize*100/fileSize));
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveFile(String command) {
        String commandArr[] = command.split(" ");
        String senderName = commandArr[0];
        long fileSize = Long.parseLong(commandArr[1]);
        String fileName = commandArr[2];
        try {
            File file = new File(String.valueOf(Path.of(System.getProperty("java.io.tmpdir")).resolve(fileName)));
            DataInputStream fileIn = new DataInputStream(socket.getInputStream());
            FileOutputStream fileOut = new FileOutputStream(file);

            byte[] buffer = new byte[64];
            int count;
            long receivedSize = 0;

            System.out.println("Receiving file from "+senderName+"...");

            while (receivedSize < fileSize) {
                count = fileIn.read(buffer);
                receivedSize += count;
                receiver.receiveFileProgress((int)(receivedSize*100/fileSize));

                //System.out.print("\r"+((int)(receivedSize*100/fileSize))+"%");
                fileOut.write(buffer, 0, count);
            }
            System.out.println();
            System.out.println("File saved as: "+file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}