package org.chessapp.move;

import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

public class Move {
    private Piece piece;
    private Coordinate src;
    private Coordinate dest;

    public Move(Piece piece, Coordinate src, Coordinate dest) {
        this.piece = piece;
        this.src = src;
        this.dest = dest;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Coordinate getSrc() {
        return src;
    }

    public void setSrc(Coordinate src) {
        this.src = src;
    }

    public Coordinate getDest() {
        return dest;
    }

    public void setDest(Coordinate dest) {
        this.dest = dest;
    }
}
