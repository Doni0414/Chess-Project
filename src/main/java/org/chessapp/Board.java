package org.chessapp;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.chessapp.piece.Piece;

import java.util.List;

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
                cells[i][j].setOnMouseClicked(e -> {
                    Piece piece = cell.getPiece();
                    if (piece != null){
                        if (piece.isBlack() == Logic.blackTurn){
                            repaint();
                            Logic.target = piece;
                            paintMoves(piece);
                            paintEatMoves(piece);
                        }else if(Logic.target != null){
                            Logic.logic(this, Logic.target, cell.getCoordinate());
                        }
                    }else if(Logic.target != null){
                        Logic.logic(this, Logic.target, cell.getCoordinate());
                    }
                });
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
    public void setPiece(Piece piece, Coordinate coordinate){
        int x = coordinate.getX(), y = coordinate.getY();
        if (piece != null){
            piece.setCoordinate(coordinate);
        }
        cells[y][x].setPiece(piece);
    }
    public void paintMoves(Piece piece){
        List<Coordinate> coordinates = piece.getMoves(this);
        for(Coordinate coordinate: coordinates){
            Cell cell = cells[coordinate.getY()][coordinate.getX()];
            cell.getRectangle().setFill(Color.GREEN);
        }
    }
    public void paintEatMoves(Piece piece){
        List<Coordinate> coordinates = piece.getEatMoves(this);
        for(Coordinate coordinate: coordinates){
            Cell cell = cells[coordinate.getY()][coordinate.getX()];
            cell.getRectangle().setFill(Color.RED);
        }
    }
    public void repaint(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0){
                    cells[i][j].getRectangle().setFill(Color.WHITE);
                }else{
                    cells[i][j].getRectangle().setFill(Color.BLACK);
                }
            }
        }
    }
    public boolean isEmptyCell(Coordinate coordinate){
        return getCell(coordinate).getPiece() == null;
    }
    public Cell getCell(Coordinate coordinate){
        return cells[coordinate.getY()][coordinate.getX()];
    }
}
