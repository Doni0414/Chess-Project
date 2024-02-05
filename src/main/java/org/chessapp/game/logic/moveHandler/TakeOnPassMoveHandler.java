package org.chessapp.game.logic.moveHandler;

import org.chessapp.game.components.board.Board;
import org.chessapp.move.Move;
import org.chessapp.move.TakeOnPassMove;
import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

public class TakeOnPassMoveHandler extends MoveHandler{
    public TakeOnPassMoveHandler(Move move) {
        super(move);
    }

    @Override
    public void handle(Board board) {
        super.handle(board);
        TakeOnPassMove move = (TakeOnPassMove) getMove();
        Coordinate eatenSrc = move.getEatenSrc();
        board.setPiece(null, eatenSrc);
    }

    @Override
    public void recover(Board board, boolean recover) {
        super.recover(board, recover);
        TakeOnPassMove move = (TakeOnPassMove) getMove();
        Piece eaten = move.getEaten();
        Coordinate eatenSrc = move.getEatenSrc();
        board.setPiece(eaten, eatenSrc);
        System.out.println("Take on pass move handler recover!");
    }
}
