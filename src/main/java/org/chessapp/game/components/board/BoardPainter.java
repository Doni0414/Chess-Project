package org.chessapp.game.components.board;

import javafx.scene.paint.Color;
import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidMove;

import java.util.List;

public class BoardPainter {
    public static void paintMoves(Board board, Piece piece){
        List<Coordinate> coordinates = piece.getMoves(board);
        Cell[][] cells = board.getCells();
        for(Coordinate coordinate: coordinates){
            Cell cell = cells[coordinate.getY()][coordinate.getX()];
            paintCell(cell, Color.GREEN);

        }
    }
    public static void paintEatMoves(Board board, Piece piece){
        List<Coordinate> coordinates = piece.getEatMoves(board);
        Cell[][] cells = board.getCells();
        for(Coordinate coordinate: coordinates){
            Cell cell = cells[coordinate.getY()][coordinate.getX()];
            paintCell(cell, Color.RED);
        }
    }
    public static void repaint(Board board){
        Cell[][] cells = board.getCells();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0){
                    paintCell(cells[i][j], Color.WHITE);
                }else{
                    paintCell(cells[i][j], Color.BLACK);
                }
            }
        }
    }
    public static void paintCell(Cell cell, Color color){
        cell.getRectangle().setFill(color);
    }
}
