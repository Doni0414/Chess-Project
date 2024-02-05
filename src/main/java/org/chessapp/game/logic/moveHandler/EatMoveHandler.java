package org.chessapp.game.logic.moveHandler;

import org.chessapp.game.components.board.Board;
import org.chessapp.move.EatMove;
import org.chessapp.move.Move;
import org.chessapp.piece.Piece;

public class EatMoveHandler extends MoveHandler{
    public EatMoveHandler(Move move) {
        super(move);
    }

    @Override
    public void handle(Board board) {
        super.handle(board);
    }

    @Override
    public void recover(Board board, boolean recover) {
        super.recover(board, recover);
        Piece eaten = ((EatMove) getMove()).getEaten();
        board.setPiece(eaten, getMove().getDest());
    }
}
