package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.game.components.board.Board;
import org.chessapp.move.EatMove;
import org.chessapp.move.Move;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidCoordinate;

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
    public List<Move> getMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

        for (int i = 0; i < dx.length; i++) {
            Coordinate newCoordinate = new Coordinate(x + dx[i], y + dy[i]);
            if (ValidCoordinate.isValidMove(newCoordinate)){
                if (board.isEmptyCell(newCoordinate)){
                    moves.add(new Move(this, coordinate, newCoordinate));
                }
            }
        }
        return moves;
    }

    @Override
    public List<Move> getEatMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
        for (int i = 0; i < dx.length; i++) {
            Coordinate newCoordinate = new Coordinate(x + dx[i], y + dy[i]);
            if (ValidCoordinate.isValidMove(newCoordinate)){
                Piece piece = board.getCell(newCoordinate).getPiece();
                if (piece != null && piece.isBlack() != isBlack()){
                    moves.add(new EatMove(this, piece, coordinate, newCoordinate));
                }
            }
        }
        return moves;
    }

    @Override
    public List<Coordinate> getAttackedCoordinates(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

        for (int i = 0; i < dx.length; i++) {
            Coordinate newCoordinate = new Coordinate(x + dx[i], y + dy[i]);
            if (ValidCoordinate.isValidMove(newCoordinate)){
                coordinates.add(newCoordinate);
            }
        }
        return coordinates;
    }
}
