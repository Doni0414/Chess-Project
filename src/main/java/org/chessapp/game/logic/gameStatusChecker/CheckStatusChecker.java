package org.chessapp.game.logic.gameStatusChecker;

import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.BoardPainter;
import org.chessapp.piece.King;
import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

import java.util.List;

public class CheckStatusChecker {
    public static boolean check(Board board, boolean blackTurn) {
        List<Piece> pieces = board.getTeam(blackTurn);
        List<Coordinate> attackedCoordinates = board.getAttackedCoordinates(!blackTurn);
        for (Piece piece: pieces) {
            if (piece instanceof King) {
                if (attackedCoordinates.contains(piece.getCoordinate())) {
                    return true;
                }
            }
        }
        return false;
    }
}
