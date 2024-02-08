package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.Cell;
import org.chessapp.move.EatMove;
import org.chessapp.move.Move;
import org.chessapp.move.RookingMove;
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
        Cell cell1, cell2;
        if (isWhite()) {
            cell1 = board.getCell(new Coordinate(0, 7));
            cell2 = board.getCell(new Coordinate(7, 7));
        }else {
            cell1 = board.getCell(new Coordinate(0, 0));
            cell2 = board.getCell(new Coordinate(7, 0));
        }
        Piece piece1 = cell1.getPiece();
        Piece piece2 = cell2.getPiece();
        if(!isMoved() && piece1 instanceof Rook && !piece1.isMoved()) {
            Coordinate kingDest = new Coordinate(coordinate.getX() - 2, coordinate.getY());
            Coordinate rookDest = new Coordinate(piece1.getCoordinate().getX() + 3, piece1.getCoordinate().getY());
            boolean flag = !attackedCoordinates.contains(coordinate);
            for (int i = coordinate.getX() - 1; i >= 1; i--) {
                Coordinate newCoordinate = new Coordinate(i, coordinate.getY());
                if (attackedCoordinates.contains(newCoordinate) || !board.isEmptyCell(newCoordinate)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                moves.add(new RookingMove(this, coordinate, kingDest, (Rook) piece1, piece1.getCoordinate(), rookDest));
            }
        }
        if(!isMoved() && piece2 instanceof Rook && !piece2.isMoved()) {
            Coordinate kingDest = new Coordinate(coordinate.getX() + 2, coordinate.getY());
            Coordinate rookDest = new Coordinate(piece2.getCoordinate().getX() - 2, piece2.getCoordinate().getY());
            boolean flag = !attackedCoordinates.contains(coordinate);
            for (int i = coordinate.getX() + 1 ; i <= kingDest.getX(); i++) {
                Coordinate newCoordinate = new Coordinate(i, coordinate.getY());
                if (attackedCoordinates.contains(newCoordinate) || !board.isEmptyCell(newCoordinate)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                moves.add(new RookingMove(this, coordinate, kingDest, (Rook) piece2, piece2.getCoordinate(), rookDest));
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
