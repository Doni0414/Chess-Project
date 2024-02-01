package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.*;
import org.chessapp.game.components.board.Board;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidMove;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(Color color, Coordinate coordinate) {
        super(' ', color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_BISHOP.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_BISHOP.getCode() + "");
        }
    }

    @Override
    public List<Coordinate> getMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 1};
        int[] dy = {-1, 1};
        for (int dxi : dx) {
            for (int dyi : dy) {
                for (int k = 1; k < Configuration.BOARD_COLS; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidMove.isValidMove(newCoordinate)) {
                        Piece piece = board.getCell(newCoordinate).getPiece();
                        if (piece == null) {
                            coordinates.add(newCoordinate);
                        } else {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return coordinates;
    }

    @Override
    public List<Coordinate> getEatMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 1};
        int[] dy = {-1, 1};
        for (int dxi : dx) {
            for (int dyi : dy) {
                for (int k = 1; k < Configuration.BOARD_COLS; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidMove.isValidMove(newCoordinate)) {
                        Piece piece = board.getCell(newCoordinate).getPiece();
                        if (piece != null) {
                            if (piece.isBlack() != isBlack()) {
                                coordinates.add(newCoordinate);
                            }
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return coordinates;
    }

    @Override
    public List<Coordinate> getAttacks(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 1};
        int[] dy = {-1, 1};
        for (int dxi : dx) {
            for (int dyi : dy) {
                for (int k = 1; k < Configuration.BOARD_COLS; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidMove.isValidMove(newCoordinate)) {
                        Piece piece = board.getCell(newCoordinate).getPiece();
                        coordinates.add(newCoordinate);
                        if (piece != null) {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return coordinates;
    }
}
