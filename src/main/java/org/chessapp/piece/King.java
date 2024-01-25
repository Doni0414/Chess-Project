package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Coordinate;
import org.chessapp.ValidMove;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(Color color, Coordinate coordinate) {
        super(' ', color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_KING.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_KING.getCode() + "");
        }
    }

    @Override
    public List<Coordinate> getMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        List<Coordinate> attackedCoordinates = board.getAttackedCoordinates();
        for (int dxi: dx){
            for (int dyi: dy){
                if (dxi == 0 && dyi == 0){
                    continue;
                }
                Coordinate newCoordinate = new Coordinate(x + dxi, y + dyi);
                if (ValidMove.isValidMove(newCoordinate) && !attackedCoordinates.contains(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece == null){
                        coordinates.add(newCoordinate);
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
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        List<Coordinate> attackedCoordinates = board.getAttackedCoordinates();

        for (int dxi: dx){
            for (int dyi: dy){
                if (dxi == 0 && dyi == 0){
                    continue;
                }
                Coordinate newCoordinate = new Coordinate(x + dxi, y + dyi);
                if (ValidMove.isValidMove(newCoordinate) && !attackedCoordinates.contains(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece != null && piece.isBlack() != isBlack()){
                        coordinates.add(newCoordinate);
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
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        for (int dxi: dx){
            for (int dyi: dy){
                if (dxi == 0 && dyi == 0){
                    continue;
                }
                Coordinate newCoordinate = new Coordinate(x + dxi, y + dyi);
                if (ValidMove.isValidMove(newCoordinate)){
                    coordinates.add(newCoordinate);
                }
            }
        }
        return coordinates;
    }
}
