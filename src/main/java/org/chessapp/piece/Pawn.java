package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Coordinate;

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
    public List<Coordinate> getMoves(Board board) {
        return null;
    }

    @Override
    public List<Coordinate> getEatMoves(Board board) {
        return null;
    }
}
