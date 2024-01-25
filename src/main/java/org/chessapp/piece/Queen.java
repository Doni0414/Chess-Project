package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Coordinate;
import org.chessapp.ValidMove;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
    public Queen(Color color, Coordinate coordinate) {
        super(' ', color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_QUEEN.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_QUEEN.getCode() + "");
        }
    }

    @Override
    public List<Coordinate> getMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int i = 0; i < dx1.length; i++) {
            for (int j = 1; j < 8; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx1[i], y + j * dy1[i]);
                if (ValidMove.isValidMove(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece == null){
                        coordinates.add(newCoordinate);
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        int[] dx2 = {-1, 1};
        int[] dy2 = {-1, 1};
        for (int dxi : dx2) {
            for (int dyi : dy2) {
                for (int k = 1; k < 8; k++) {
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
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int i = 0; i < dx1.length; i++) {
            for (int j = 1; j < 8; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx1[i], y + j * dy1[i]);
                if (ValidMove.isValidMove(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece != null){
                        if (piece.isBlack() != isBlack()){
                            coordinates.add(newCoordinate);
                        }
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        int[] dx2 = {-1, 1};
        int[] dy2 = {-1, 1};
        for (int dxi : dx2) {
            for (int dyi : dy2) {
                for (int k = 1; k < 8; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidMove.isValidMove(newCoordinate)) {
                        Piece piece = board.getCell(newCoordinate).getPiece();
                        if (piece != null){
                            if (piece.isBlack() != isBlack()){
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
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int i = 0; i < dx1.length; i++) {
            for (int j = 1; j < 8; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx1[i], y + j * dy1[i]);
                if (ValidMove.isValidMove(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    coordinates.add(newCoordinate);
                    if(piece != null){
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        int[] dx2 = {-1, 1};
        int[] dy2 = {-1, 1};
        for (int dxi : dx2) {
            for (int dyi : dy2) {
                for (int k = 1; k < 8; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidMove.isValidMove(newCoordinate)) {
                        Piece piece = board.getCell(newCoordinate).getPiece();
                        coordinates.add(newCoordinate);
                        if(piece != null){
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
