package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Coordinate;

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
        return null;
    }

    @Override
    public List<Coordinate> getEatMoves(Board board) {
        return null;
    }
}
