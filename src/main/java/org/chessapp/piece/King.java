package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.game.components.board.Board;
import org.chessapp.move.EatMove;
import org.chessapp.move.Move;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidCoordinate;

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
    public List<Move> getMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        List<Coordinate> attackedCoordinates = board.getAttackedCoordinates(!isBlack());
        for (int dxi: dx){
            for (int dyi: dy){
                if (dxi == 0 && dyi == 0){
                    continue;
                }
                Coordinate newCoordinate = new Coordinate(x + dxi, y + dyi);
                if (ValidCoordinate.isValidMove(newCoordinate) && !attackedCoordinates.contains(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece == null){
                        moves.add(new Move(this, coordinate, newCoordinate));
                    }
                }
            }
        }
        return moves;
    }

    @Override
    public List<Move> getEatMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        List<Coordinate> attackedCoordinates = board.getAttackedCoordinates(!isBlack());

        for (int dxi: dx){
            for (int dyi: dy){
                if (dxi == 0 && dyi == 0){
                    continue;
                }
                Coordinate newCoordinate = new Coordinate(x + dxi, y + dyi);
                if (ValidCoordinate.isValidMove(newCoordinate) && !attackedCoordinates.contains(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece != null && piece.isBlack() != isBlack()){
                        moves.add(new EatMove(this, piece, coordinate, newCoordinate));
                    }
                }
            }
        }
        return moves;
    }

    @Override
    public List<Coordinate> getAttackedCoordinates(Board board) {
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
                if (ValidCoordinate.isValidMove(newCoordinate)){
                    coordinates.add(newCoordinate);
                }
            }
        }
        return coordinates;
    }
}
