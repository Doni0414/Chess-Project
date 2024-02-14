package org.chessapp.game.components.board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.chessapp.Configuration;
import org.chessapp.utils.Coordinate;
import org.chessapp.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board extends Pane {
    private Cell[][] cells;
    private GridPane grid;

    public Board(double width, double height){
        grid = new GridPane();
        this.cells = new Cell[Configuration.BOARD_ROWS][Configuration.BOARD_COLS];
        for (int i = 0; i < Configuration.BOARD_ROWS; i++) {
            for (int j = 0; j < Configuration.BOARD_COLS; j++) {
                Cell cell;
                if ((i + j) % 2 == 0){
                    cell = new Cell(width / Configuration.BOARD_COLS, height / Configuration.BOARD_ROWS, Color.WHITE, new Coordinate(j, i));
                }else{
                    cell = new Cell(width / Configuration.BOARD_COLS, height / Configuration.BOARD_ROWS, Color.BLACK, new Coordinate(j, i));
                }
                cells[i][j] = cell;
                grid.add(cell, j, i);
            }
        }
        getChildren().add(grid);
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

    public boolean isEmptyCell(Coordinate coordinate){
        return getCell(coordinate).getPiece() == null;
    }
    public Cell getCell(Coordinate coordinate){
        return cells[coordinate.getY()][coordinate.getX()];
    }
    public List<Coordinate> getAttackedCoordinates(boolean isBlack){
        List<Coordinate> coordinates = new ArrayList<>();
        for (Piece piece: getTeam(isBlack)){
            if (piece != null && isBlack == piece.isBlack()){
                List<Coordinate> attacks = piece.getAttackedCoordinates(this);
                if (attacks != null) {
                    coordinates.addAll(attacks);
                }
            }
        }
        return coordinates;
    }

    public List<Piece> getTeam(boolean isBlack){
        List<Piece> pieces = new ArrayList<>();
        for (Cell[] cs: cells){
            for (Cell cell: cs){
                Piece piece = cell.getPiece();
                if (piece != null && isBlack == piece.isBlack()){
                    pieces.add(piece);
                }
            }
        }
        return pieces;
    }
}
