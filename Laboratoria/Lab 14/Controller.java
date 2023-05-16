package com.example.circleapp;

import com.example.circleapp.client.ServerThread;
import com.example.circleapp.server.Server;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    private Server server;
    private ServerThread serverThread;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Slider radiusSlider;

    public Controller(Server server, ServerThread serverThread) {
        this.server = server;
        this.serverThread = serverThread;
        this.serverThread.setDraw(dp -> {
            GraphicsContext context = canvas.getGraphicsContext2D();
            context.setFill(Color.web(dp.color()));
            context.fillOval(dp.x() - dp.radius(), dp.y() - dp.radius(), dp.radius() * 2, dp.radius() * 2);
        });
    }

    @FXML
    private TextField addressField, portField;

    @FXML
    private void onStartServerClicked() {
        server.setAddress(addressField.getText());
        server.setPort(Integer.parseInt(portField.getText()));
        server.start();

        serverThread.connectToServer("localhost", Integer.parseInt(portField.getText()));
    }

    @FXML
    private void onConnectClicked() {
        serverThread.connectToServer(addressField.getText(), Integer.parseInt(portField.getText()));
    }

    private static String colorToHexString(Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
    @FXML
    private void onMouseClicked(MouseEvent event) {
        double radius = radiusSlider.getValue();
        Color color = colorPicker.getValue();

        serverThread.send((int) event.getX(), (int) event.getY(), colorToHexString(color), (int) radius);
        //drawCircle((int)event.getX(), (int)event.getY(), radius, color);
    }

//    public void drawCircle(int x, int y, int radius, Color color) {
//        GraphicsContext context = canvas.getGraphicsContext2D();
//
//        context.setFill(Color.web(dp.color()));
//        context.fillOval(x - radius, y - radius, radius * 2, radius * 2);
//    }
}