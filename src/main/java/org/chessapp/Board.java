package org.chessapp;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends GridPane {
    public Board(double width, double height){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(0, 0, width / 8, height / 8);
                if ((i + j) % 2 == 0){
                    rectangle.setFill(Color.WHITE);
                }
                add(rectangle, j, i);
            }
        }
    }
}
