package org.chessapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public static final double W = 600, H = 600;

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(0, 0, W / 8, H / 8);
                if ((i + j) % 2 == 0){
                    rectangle.setFill(Color.WHITE);
                }
                grid.add(rectangle, j, i);
            }
        }
        Scene scene = new Scene(grid, W, H);
        stage.setScene(scene);
        stage.setTitle("Show grid");
        stage.show();
    }
}
