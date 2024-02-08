package org.chessapp.move;

import org.chessapp.piece.King;
import org.chessapp.piece.Rook;
import org.chessapp.utils.Coordinate;

public class RookingMove extends Move{
    private Rook rook;
    private Coordinate rookSrc;
    private Coordinate rookDest;

    public RookingMove(King king, Coordinate kingSrc, Coordinate kingDest, Rook rook, Coordinate rookSrc, Coordinate rookDest) {
        super(king, kingSrc, kingDest);
        setRook(rook);
        setRookSrc(rookSrc);
        setRookDest(rookDest);
    }

    public Rook getRook() {
        return rook;
    }

    public void setRook(Rook rook) {
        this.rook = rook;
    }

    public Coordinate getRookSrc() {
        return rookSrc;
    }

    public void setRookSrc(Coordinate rookSrc) {
        this.rookSrc = rookSrc;
    }

    public Coordinate getRookDest() {
        return rookDest;
    }

    public void setRookDest(Coordinate rookDest) {
        this.rookDest = rookDest;
    }
}
