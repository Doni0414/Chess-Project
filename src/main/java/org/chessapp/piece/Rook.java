package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Cell;
import org.chessapp.Coordinate;
import org.chessapp.ValidMove;

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
}
