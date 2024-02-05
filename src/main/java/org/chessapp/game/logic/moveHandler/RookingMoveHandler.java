package org.chessapp.game.logic.moveHandler;

import org.chessapp.game.components.board.Board;
import org.chessapp.move.Move;

public class RookingMoveHandler extends MoveHandler {
    public RookingMoveHandler(Move move) {
        super(move);
    }

    @Override
    public void handle(Board board) {
        super.handle(board);
    }

    @Override
    public void recover(Board board, boolean recover) {
        super.recover(board, recover);
    }
}
