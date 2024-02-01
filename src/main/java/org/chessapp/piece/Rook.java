package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.*;
import org.chessapp.game.components.board.Board;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidMove;

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
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < dx.length; i++) {
            for (int j = 1; j < Configuration.BOARD_COLS; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx[i], y + j * dy[i]);
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
        return coordinates;
    }

    @Override
    public List<Coordinate> getEatMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < dx.length; i++) {
            for (int j = 1; j < Configuration.BOARD_COLS; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx[i], y + j * dy[i]);
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
        return coordinates;
    }

    @Override
    public List<Coordinate> getAttacks(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < dx.length; i++) {
            for (int j = 1; j < Configuration.BOARD_COLS; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx[i], y + j * dy[i]);
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
        return coordinates;
    }
}
