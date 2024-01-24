package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Cell;
import org.chessapp.Coordinate;
import org.chessapp.ValidMove;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(Color color, Coordinate coordinate) {
        super(' ', color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_KNIGHT.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_KNIGHT.getCode() + "");
        }
    }

    @Override
    public List<Coordinate> getMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
        for (int i = 0; i < dx.length; i++) {
            Coordinate newCoordinate = new Coordinate(x + dx[i], y + dy[i]);
            if (ValidMove.isValidMove(newCoordinate)){
                if (board.isEmptyCell(newCoordinate)){
                    coordinates.add(newCoordinate);
                }
            }
        }
        return coordinates;
    }

    @Override
    public List<Coordinate> getEatMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
        for (int i = 0; i < dx.length; i++) {
            Coordinate newCoordinate = new Coordinate(x + dx[i], y + dy[i]);
            if (ValidMove.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece != null && piece.isBlack() != isBlack()){
                    coordinates.add(newCoordinate);
                }
            }
        }
        return coordinates;
    }
}
