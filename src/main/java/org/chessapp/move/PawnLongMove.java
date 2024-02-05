package org.chessapp.move;

import org.chessapp.game.components.board.Cell;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

public class PawnLongMove extends Move{
    private Cell cell;
    public PawnLongMove(Pawn pawn, Coordinate src, Coordinate dest, Cell cell) {
        super(pawn, src, dest);
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }
}
