package org.chessapp.game.logic.moveHandler;

import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.Cell;
import org.chessapp.move.Move;
import org.chessapp.move.PawnLongMove;
import org.chessapp.move.TakeOnPassMove;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.TakeOnPass;

public class PawnLongMoveHandler extends MoveHandler{
    public PawnLongMoveHandler(Move move) {
        super(move);
    }

    @Override
    public void handle(Board board) {
        super.handle(board);
        Pawn pawn = (Pawn) getMove().getPiece();
        Cell cell = ((PawnLongMove) getMove()).getCell();
        cell.setTakeOnPass(new TakeOnPass(pawn, cell.getCoordinate()));
    }

    @Override
    public void recover(Board board, boolean recover) {
        super.recover(board, recover);
        Cell cell = ((PawnLongMove) getMove()).getCell();
        cell.setTakeOnPass(null);
    }
}
