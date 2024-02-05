package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.game.components.board.Board;
import org.chessapp.Configuration;
import org.chessapp.move.EatMove;
import org.chessapp.move.Move;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidCoordinate;

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
    public List<Move> getMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int i = 0; i < dx1.length; i++) {
            for (int j = 1; j < Configuration.BOARD_COLS; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx1[i], y + j * dy1[i]);
                if (ValidCoordinate.isValidMove(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece == null){
                        moves.add(new Move(this, coordinate, newCoordinate));
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
                for (int k = 1; k < Configuration.BOARD_COLS; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidCoordinate.isValidMove(newCoordinate)) {
                        Piece piece = board.getCell(newCoordinate).getPiece();
                        if (piece == null) {
                            moves.add(new Move(this, coordinate, newCoordinate));
                        } else {
                            break;
                        }
                    }else{
                        break;
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
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int i = 0; i < dx1.length; i++) {
            for (int j = 1; j < Configuration.BOARD_COLS; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx1[i], y + j * dy1[i]);
                if (ValidCoordinate.isValidMove(newCoordinate)){
                    Piece piece = board.getCell(newCoordinate).getPiece();
                    if (piece != null){
                        if (piece.isBlack() != isBlack()){
                            moves.add(new EatMove(this, piece, coordinate, newCoordinate));
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
                for (int k = 1; k < Configuration.BOARD_COLS; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidCoordinate.isValidMove(newCoordinate)) {
                        Piece piece = board.getCell(newCoordinate).getPiece();
                        if (piece != null){
                            if (piece.isBlack() != isBlack()){
                                moves.add(new EatMove(this, piece, coordinate, newCoordinate));
                            }
                            break;
                        }
                    }else{
                        break;
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
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int i = 0; i < dx1.length; i++) {
            for (int j = 1; j < Configuration.BOARD_COLS; j++) {
                Coordinate newCoordinate = new Coordinate(x + j * dx1[i], y + j * dy1[i]);
                if (ValidCoordinate.isValidMove(newCoordinate)){
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
                for (int k = 1; k < Configuration.BOARD_COLS; k++) {
                    Coordinate newCoordinate = new Coordinate(x + k * dxi, y + k * dyi);
                    if (ValidCoordinate.isValidMove(newCoordinate)) {
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
