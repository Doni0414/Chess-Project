package org.chessapp.piece;

import org.chessapp.Coordinate;

public class TakeOnPass {
    private Pawn pawn;
    private Coordinate coordinate;

    public TakeOnPass(Pawn pawn, Coordinate coordinate) {
        this.pawn = pawn;
        this.coordinate = coordinate;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
