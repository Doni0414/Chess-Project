package org.chessapp.piece;

import org.chessapp.utils.Coordinate;

public class TakeOnPass {
    private Pawn pawn;
    private Coordinate coordinate;
    private int status = 1;

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
    public boolean isNew(){
        return status == 1;
    }
    public void setStatusOld(){
        status = 2;
    }
}
