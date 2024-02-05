package org.chessapp.game.logic.gameStatusChecker;

import org.chessapp.game.components.board.Board;
import org.chessapp.game.logic.Mover;
import org.chessapp.move.Move;
import org.chessapp.piece.King;
import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

import java.util.List;

public class MateStatusChecker {
    public static boolean check(Board board, boolean blackTurn){
        List<Piece> pieces = board.getTeam(blackTurn);
        for (Piece piece: pieces) {
            List<Move> moves = piece.getMoves(board);
            moves.addAll(piece.getEatMoves(board));
            for (Move move: moves) {
                boolean check = Mover.move(board, piece, move.getDest(), true);
                if (check) {
                    return false;
                }
            }
        }
        return true;
    }
}
