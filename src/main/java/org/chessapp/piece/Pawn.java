package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.Cell;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.ValidMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    private boolean moved;
    public Pawn(Color color, Coordinate coordinate) {
        super(' ', color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_PAWN.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_PAWN.getCode() + "");
        }
    }

    @Override
    public List<Coordinate> getMoves(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int x = coordinate.getX(), y = coordinate.getY();

        if (isMoved()){
            Coordinate coordinate;
            if (isWhite()){
                coordinate = new Coordinate(x, y - 1);
            }else{
                coordinate = new Coordinate(x, y + 1);
            }
            if (ValidMove.isValidMove(coordinate) && board.isEmptyCell(coordinate)) {
                coordinates.add(coordinate);
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

            if (ValidMove.isValidMove(coordinate1) && board.isEmptyCell(coordinate1)) {
                coordinates.add(coordinate1);
            }
            if (ValidMove.isValidMove(coordinate2) && board.isEmptyCell(coordinate2)) {
                coordinates.add(coordinate2);
            }
        }
        return coordinates;
    }

    @Override
    public List<Coordinate> getEatMoves(Board board) {
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
        if (ValidMove.isValidMove(coordinate1)){
            Cell cell1 = board.getCell(coordinate1);
            Piece piece1 = cell1.getPiece();
            if (piece1 != null && isBlack() != piece1.isBlack()) {
                coordinates.add(coordinate1);
            }else if(piece1 == null && cell1.getTakeOnPass() != null){
                coordinates.add(coordinate1);
            }
        }
        if (ValidMove.isValidMove(coordinate2)) {
            Cell cell2 = board.getCell(coordinate2);
            Piece piece2 = cell2.getPiece();
            if (piece2 != null && isBlack() != piece2.isBlack()) {
                coordinates.add(coordinate2);
            }else if(piece2 == null && cell2.getTakeOnPass() != null){
                coordinates.add(coordinate2);
            }
        }
        return coordinates;
    }
    @Override
    public List<Coordinate> getAttacks(Board board){
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
        if (ValidMove.isValidMove(coordinate1)){
            coordinates.add(coordinate1);
        }
        if (ValidMove.isValidMove(coordinate2)) {
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
