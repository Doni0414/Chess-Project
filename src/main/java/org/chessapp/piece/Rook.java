package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.*;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    public Rook(Color color, Coordinate coordinate) {
        super(' ', color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_ROOK.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_ROOK.getCode() + "");
        }
    }

    @Override
    public List<Coordinate> getMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        for (int i = x - 1; i >= 0; i--) {
            Coordinate newCoordinate = new Coordinate(i, y);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece == null){
                    coordinates.add(newCoordinate);
                }else{
                    break;
                }
            }
        }
        for (int i = x + 1; i < 8; i++) {
            Coordinate newCoordinate = new Coordinate(i, y);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece == null){
                    coordinates.add(newCoordinate);
                }else{
                    break;
                }
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            Coordinate newCoordinate = new Coordinate(x, i);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece == null){
                    coordinates.add(newCoordinate);
                }else{
                    break;
                }
            }
        }
        for (int i = y + 1; i < 8; i++) {
            Coordinate newCoordinate = new Coordinate(x, i);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece == null){
                    coordinates.add(newCoordinate);
                }else{
                    break;
                }
            }
        }
        return coordinates;
    }

    @Override
    public List<Coordinate> getEatMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        for (int i = x - 1; i >= 0; i--) {
            Coordinate newCoordinate = new Coordinate(i, y);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece != null){
                    if (piece.isBlack() != isBlack()) {
                        coordinates.add(newCoordinate);
                    }
                    break;
                }
            }
        }
        for (int i = x + 1; i < 8; i++) {
            Coordinate newCoordinate = new Coordinate(i, y);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece != null){
                    if (piece.isBlack() != isBlack()) {
                        coordinates.add(newCoordinate);
                    }
                    break;
                }
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            Coordinate newCoordinate = new Coordinate(x, i);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece != null){
                    if (piece.isBlack() != isBlack()) {
                        coordinates.add(newCoordinate);
                    }
                    break;
                }
            }
        }
        for (int i = y + 1; i < 8; i++) {
            Coordinate newCoordinate = new Coordinate(x, i);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece != null){
                    if (piece.isBlack() != isBlack()) {
                        coordinates.add(newCoordinate);
                    }
                    break;
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
            for (int j = 1; j < Configuration.BOARD_COLS; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx1[i], y + j * dy1[i]);
                if (ValidMove.isValidMove(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    coordinates.add(newCoordinate);
                    if (piece != null){
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return coordinates;
    }
}
