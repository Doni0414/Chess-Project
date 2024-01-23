package org.chessapp;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Board extends GridPane {
    private Cell[][] cells;
    public Board(double width, double height){
        this.cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell;
                if ((i + j) % 2 == 0){
                    cell = new Cell(width / 8, height / 8, Color.WHITE, new Coordinate(j, i));
                }else{
                    cell = new Cell(width / 8, height / 8, Color.BLACK, new Coordinate(j, i));
                }
                cells[i][j] = cell;
                add(cell, j, i);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
