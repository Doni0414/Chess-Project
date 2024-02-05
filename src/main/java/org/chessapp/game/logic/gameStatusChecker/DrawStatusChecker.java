package org.chessapp.game.logic.gameStatusChecker;

import org.chessapp.game.components.board.Board;
import org.chessapp.move.Move;
import org.chessapp.piece.Piece;

import java.util.List;

public class DrawStatusChecker {
    public static boolean check(Board board, boolean blackTurn){
        List<Piece> team = board.getTeam(blackTurn);
        for (Piece piece: team) {
            List<Move> moves = piece.getMoves(board);
            moves.addAll(piece.getEatMoves(board));
            if (moves.size() != 0){
                return false;
            }
        }
        return true;
    }
}
