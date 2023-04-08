package com.example.circleapp.client;

import com.example.circleapp.Dot;

import java.io.*;
import java.net.Socket;
import java.util.function.Consumer;

public class ServerThread extends Thread {
    private Socket socket;
    private PrintWriter writer;
    private Consumer<Dot> draw;

    public void setDraw(Consumer<Dot> draw) {
        this.draw = draw;
    }

    public void connectToServer(String address, int port) {
        try {
            socket = new Socket(address, port);
            start();
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
                Dot dot = Dot.fromMessage(message);
//                String arr[] = message.split(";");
//                int x = Integer.parseInt(arr[0]);
//                int y = Integer.parseInt(arr[1]);
//                String color = arr[2];
//                int radius = Integer.parseInt(arr[3]);
//                Dot drawParameters = new Dot(x, y, color, radius);
                draw.accept(dot);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(int x, int y, String color, int radius) {
        writer.println(Dot.toMessage(x, y, color, radius));
    }
}
