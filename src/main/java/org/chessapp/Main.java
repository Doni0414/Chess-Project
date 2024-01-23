package org.chessapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board(Configuration.W, Configuration.H);
        Scene scene = new Scene(board, Configuration.W, Configuration.H);
        stage.setScene(scene);
        stage.setTitle("Show board");
        stage.show();
    }
}
