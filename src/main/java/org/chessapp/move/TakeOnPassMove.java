package org.chessapp.move;

import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

public class TakeOnPassMove extends EatMove{
    private final Coordinate eatenSrc;
    public TakeOnPassMove(Piece piece, Piece eaten, Coordinate src, Coordinate dest, Coordinate eatenSrc) {
        super(piece, eaten, src, dest);
        this.eatenSrc = eatenSrc;
    }

    public Coordinate getEatenSrc() {
        return eatenSrc;
    }
}
