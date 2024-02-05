package org.chessapp.game.logic.gameStatusHandler;

import org.chessapp.game.Game;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.BoardPainter;
import org.chessapp.game.logic.gameStatusChecker.CheckStatusChecker;
import org.chessapp.game.logic.gameStatusChecker.DrawStatusChecker;
import org.chessapp.game.logic.gameStatusChecker.MateStatusChecker;

public class GameStatusHandler {
    public static void check(Game game, Board board) {
        if (CheckStatusChecker.check(board, game.isBlackTurn())) {
            game.setStatus("Check for " + (game.isBlackTurn() ? "Black King" : "White King"));
            BoardPainter.paintCheck(board, game.isBlackTurn());
        }else {
            game.setStatus("Ongoing");
        }
    }
    public static void mate(Game game, Board board) {
        if (MateStatusChecker.check(board, game.isBlackTurn())) {
            game.setStatus("Mate for " + (game.isBlackTurn() ? "Black!\nWhite wins!" : "White!\nBlack wins!"));
            BoardPainter.paintMate(board, game.isBlackTurn());
            game.setFinished(true);
        }else {
            game.setStatus("Ongoing");
        }
    }
    public static void draw(Game game, Board board) {
        if (DrawStatusChecker.check(board, game.isBlackTurn())) {
            game.setStatus("Draw!" + (game.isBlackTurn() ? " Black has no moves" : " White has no moves"));
            game.setFinished(true);
        }else {
            game.setStatus("Ongoing");
        }
    }
}
