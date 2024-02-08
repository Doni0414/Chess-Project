package org.chessapp.game.logic.moveHandler;

import org.chessapp.game.components.board.Board;
import org.chessapp.move.Move;
import org.chessapp.move.RookingMove;
import org.chessapp.piece.King;
import org.chessapp.piece.Rook;
import org.chessapp.utils.Coordinate;

public class RookingMoveHandler extends MoveHandler {
    public RookingMoveHandler(Move move) {
        super(move);
    }

    @Override
    public void handle(Board board) {
        super.handle(board);
//        King king = (King) getMove().getPiece();
//        Coordinate kingSrc = getMove().getSrc();
//        Coordinate kingDest = getMove().getDest();

        Rook rook = ((RookingMove) getMove()).getRook();
        Coordinate rookSrc = ((RookingMove) getMove()).getRookSrc();
        Coordinate rookDest = ((RookingMove) getMove()).getRookDest();

        board.setPiece(null, rookSrc);
        board.setPiece(rook, rookDest);
        rook.setMoved(true);
    }

    @Override
    public void recover(Board board, boolean recover) {
        super.recover(board, recover);
        Rook rook = ((RookingMove) getMove()).getRook();
        Coordinate rookSrc = ((RookingMove) getMove()).getRookSrc();
        Coordinate rookDest = ((RookingMove) getMove()).getRookDest();

        board.setPiece(null, rookDest);
        board.setPiece(rook, rookSrc);
        if (recover) {
            rook.setMoved(false);
        }
    }
}
