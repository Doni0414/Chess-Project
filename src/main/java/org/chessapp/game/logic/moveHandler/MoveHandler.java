package org.chessapp.game.logic.moveHandler;

import org.chessapp.game.components.board.Board;
import org.chessapp.move.Move;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.Piece;

public class MoveHandler {
    private final Move move;

    public MoveHandler(Move move){
        this.move = move;
    }
    public void handle(Board board) {
        Piece piece = move.getPiece();
        if (piece instanceof Pawn) {
            ((Pawn) piece).setMoved(true);
            System.out.println(((Pawn) piece).isMoved() + " from handle!");
        }
        board.setPiece(null, move.getSrc());
        board.setPiece(piece, move.getDest());
    }
    public void recover(Board board, boolean recover) {
        Piece piece = move.getPiece();
        if (recover) {
            piece.setMoved(false);
            System.out.println(piece.isMoved() + " from recover!");
        }
        board.setPiece(null, move.getDest());
        board.setPiece(piece, move.getSrc());
    }
    public Move getMove(){
        return move;
    }
}
