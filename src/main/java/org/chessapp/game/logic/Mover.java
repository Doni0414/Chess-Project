package org.chessapp.game.logic;

import org.chessapp.game.components.board.Board;
import org.chessapp.game.logic.gameStatusChecker.CheckStatusChecker;
import org.chessapp.game.logic.moveHandler.*;
import org.chessapp.move.*;
import org.chessapp.piece.Piece;
import org.chessapp.piece.Rook;
import org.chessapp.utils.Coordinate;
import org.chessapp.utils.TakeOnPassUtils;

import java.util.List;
import java.util.Optional;

public class Mover {
    public static boolean move(Board board, Piece piece, Coordinate dest, boolean recover){
        List<Move> moves = piece.getMoves(board);
        List<Move> eatMoves = piece.getEatMoves(board);
        moves.addAll(eatMoves);
        Optional<Move> foundMove = findMoveByDestinationCoordinate(moves, dest);
        if (foundMove.isPresent()) {
            Move move = foundMove.get();
            MoveHandler moveHandler;
            if (move instanceof TakeOnPassMove) {
                moveHandler = new TakeOnPassMoveHandler(move);
            } else if(move instanceof EatMove) {
                moveHandler = new EatMoveHandler(move);
            } else if (move instanceof RookingMove) {
                moveHandler = new RookingMoveHandler(move);
            } else if(move instanceof PawnLongMove) {
                moveHandler = new PawnLongMoveHandler(move);
            } else {
                moveHandler = new MoveHandler(move);
            }
            boolean isMoved = piece.isMoved();
            moveHandler.handle(board);
            if (CheckStatusChecker.check(board, piece.isBlack())) {
                moveHandler.recover(board, !isMoved);
                return false;
            }
            if (recover) {
                moveHandler.recover(board, !isMoved);
            } else {
                TakeOnPassUtils.clearTakeOnPass(board);
            }
            return true;
        }
        return false;
    }

    public static Optional<Move> findMoveByDestinationCoordinate(List<Move> moves, Coordinate dest){
        return moves.stream()
                .filter(move -> move.getDest().equals(dest)).findFirst();
    }
}
