package org.chessapp.piece;

import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Coordinate;

import java.util.List;

public class Rook extends Piece{

    public Rook(char c, Color color, Coordinate coordinate) {
        super(c, color, coordinate);
        if (isBlack()){
            setText(PieceCode.BLACK_ROOK.getCode() + "");
        }else if(isWhite()){
            setText(PieceCode.WHITE_ROOK.getCode() + "");
        }
    }

    @Override
    public List<Coordinate> getMoves(Board board) {
        return null;
    }
}
