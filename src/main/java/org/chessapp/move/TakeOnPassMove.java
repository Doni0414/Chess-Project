package org.chessapp.move;

import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

public class TakeOnPassMove extends EatMove{
    public TakeOnPassMove(Piece piece, Piece eaten, Coordinate src, Coordinate dest) {
        super(piece, eaten, src, dest);
    }
}
