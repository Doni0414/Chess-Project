package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.Cell;
import org.chessapp.move.EatMove;
import org.chessapp.move.Move;
import org.chessapp.move.PawnLongMove;
import org.chessapp.move.TakeOnPassMove;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidCoordinate;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    public Pawn(Color color, Coordinate coordinate) {
        super(' ', color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_PAWN.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_PAWN.getCode() + "");
        }
    }

    @Override
    public List<Move> getMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();

        if (isMoved()){
            Coordinate coordinate;
            if (isWhite()){
                coordinate = new Coordinate(x, y - 1);
            }else{
                coordinate = new Coordinate(x, y + 1);
            }
            if (ValidCoordinate.isValidMove(coordinate) && board.isEmptyCell(coordinate)) {
                moves.add(new Move(this, this.coordinate, coordinate));
            }
        }else{
            Coordinate coordinate1;
            Coordinate coordinate2;

            if (isWhite()){
                coordinate1 = new Coordinate(x, y - 1);
                coordinate2 = new Coordinate(x, y - 2);
            }else {
                coordinate1 = new Coordinate(x, y + 1);
                coordinate2 = new Coordinate(x, y + 2);
            }

            if (ValidCoordinate.isValidMove(coordinate1) && board.isEmptyCell(coordinate1)) {
                moves.add(new Move(this, this.coordinate, coordinate1));
            }
            if (ValidCoordinate.isValidMove(coordinate2) && board.isEmptyCell(coordinate2)) {
                Coordinate takeOnPassCoordinate = new Coordinate(coordinate2.getX(), coordinate2.getY() + (isWhite() ? 1 : -1));
                Cell cell = board.getCell(takeOnPassCoordinate);
                moves.add(new PawnLongMove(this, this.coordinate, coordinate2, cell));
            }
        }
        return moves;
    }

    @Override
    public List<Move> getEatMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        Coordinate coordinate1, coordinate2;
        if (isWhite()){
            coordinate1 = new Coordinate(x - 1, y - 1);
            coordinate2 = new Coordinate(x + 1, y - 1);
        }else{
            coordinate1 = new Coordinate(x - 1, y + 1);
            coordinate2 = new Coordinate(x + 1, y + 1);
        }
        if (ValidCoordinate.isValidMove(coordinate1)){
            Cell cell1 = board.getCell(coordinate1);
            Piece piece1 = cell1.getPiece();
            if (piece1 != null && isBlack() != piece1.isBlack()) {
                moves.add(new EatMove(this, piece1, coordinate, coordinate1));
            }else if(piece1 == null && cell1.getTakeOnPass() != null && cell1.getTakeOnPass().getPawn().isBlack() != isBlack()){
                moves.add(new TakeOnPassMove(this, cell1.getTakeOnPass().getPawn(), coordinate, coordinate1, cell1.getTakeOnPass().getPawn().getCoordinate()));
            }
        }
        if (ValidCoordinate.isValidMove(coordinate2)) {
            Cell cell2 = board.getCell(coordinate2);
            Piece piece2 = cell2.getPiece();
            if (piece2 != null && isBlack() != piece2.isBlack()) {
                moves.add(new EatMove(this, piece2, coordinate, coordinate2));
            }else if(piece2 == null && cell2.getTakeOnPass() != null && cell2.getTakeOnPass().getPawn().isBlack() != isBlack()){
                moves.add(new TakeOnPassMove(this, cell2.getTakeOnPass().getPawn(), coordinate, coordinate2, cell2.getTakeOnPass().getPawn().getCoordinate()));
            }
        }
        return moves;
    }
    @Override
    public List<Coordinate> getAttackedCoordinates(Board board){
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();
        Coordinate coordinate1, coordinate2;
        if (isWhite()){
            coordinate1 = new Coordinate(x - 1, y - 1);
            coordinate2 = new Coordinate(x + 1, y - 1);
        }else{
            coordinate1 = new Coordinate(x - 1, y + 1);
            coordinate2 = new Coordinate(x + 1, y + 1);
        }
        if (ValidCoordinate.isValidMove(coordinate1)){
            coordinates.add(coordinate1);
        }
        if (ValidCoordinate.isValidMove(coordinate2)) {
            coordinates.add(coordinate2);
        }
        return coordinates;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
