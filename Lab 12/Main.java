package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameCanvas gameCanvas = new GameCanvas();
        primaryStage.setTitle("Game");

        GridPane pane = new GridPane();

        pane.add(gameCanvas,0,0);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setResizable(false);
        gameCanvas.initialize();
        gameCanvas.draw();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
