package org.chessapp.game.logic.gameStatusChecker;

import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.Cell;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

import java.util.Optional;

public class PromotionChecker {
    public static Optional<Pawn> getPromotion(Board board) {
        for (int i = 0; i < 8; i++) {
            Coordinate coordinate = new Coordinate(i, 0);
            Cell cell = board.getCell(coordinate);
            Piece piece = cell.getPiece();
            if (piece instanceof Pawn) {
                return Optional.of((Pawn) piece);
            }
        }
        for (int i = 0; i < 8; i++) {
            Coordinate coordinate = new Coordinate(i, 7);
            Cell cell = board.getCell(coordinate);
            Piece piece = cell.getPiece();
            if (piece instanceof Pawn) {
                return Optional.of((Pawn) piece);
            }
        }
        return Optional.empty();
    }
}
