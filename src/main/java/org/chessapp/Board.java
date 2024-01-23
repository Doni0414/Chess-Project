package org.chessapp;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends GridPane {
    public Board(double width, double height){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell;
                if ((i + j) % 2 == 0){
                    cell = new Cell(width / 8, height / 8, Color.WHITE);
                }else{
                    cell = new Cell(width / 8, height / 8, Color.BLACK);
                }
                add(cell, j, i);
            }
        }
    }
}
