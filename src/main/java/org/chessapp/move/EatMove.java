package org.chessapp.move;

import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

public class EatMove extends Move {
    private Piece eaten;
    public EatMove(Piece piece, Piece eaten, Coordinate src, Coordinate dest) {
        super(piece, src, dest);
        this.eaten = eaten;
    }

    public Piece getEaten() {
        return eaten;
    }

    public void setEaten(Piece eaten) {
        this.eaten = eaten;
    }
//    @Override
//    public EatMove clone() {
//        Move move = super.clone();
//        EatMove clone = new EatMove();
//        return clone;
//    }
}
