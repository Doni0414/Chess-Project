package org.chessapp.game.logic;

import javafx.scene.paint.Color;
import org.chessapp.game.Game;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.BoardPainter;
import org.chessapp.game.components.board.Cell;
import org.chessapp.game.logic.gameStatusChecker.CheckStatusChecker;
import org.chessapp.game.logic.gameStatusHandler.GameStatusHandler;
import org.chessapp.piece.Piece;
import org.chessapp.utils.TakeOnPassUtils;

public class Logic {
    private Piece target;
    private final Board board;
    private final Game game;

    public Logic(Game game, Board board){
        this.game = game;
        this.board = board;
        for (Cell[] cells: board.getCells()){
            for (Cell cell: cells){
                cell.setOnMouseClicked(e -> {
                    logic(cell);
                });
            }
        }
    }

    public void logic(Cell cell){
        if (!game.isFinished()){
            Piece piece = cell.getPiece();
            if (piece != null){
                if (piece.isBlack() == game.isBlackTurn()){
                    BoardPainter.repaint(board);
                    GameStatusHandler.check(game, board);
                    setTarget(piece);
                    cell.getRectangle().setFill(Color.BLUE);
                    BoardPainter.paintMoves(board, piece);
                    BoardPainter.paintEatMoves(board, piece);
                }else if(target != null){
                    move(cell);
                }
            }else if(target != null){
                move(cell);
            }
        }
    }

    public void move(Cell cell) {
        BoardPainter.repaint(board);
        if(Mover.move(board, target, cell.getCoordinate(), false)){
            game.setBlackTurn(!game.isBlackTurn());
        }
        GameStatusHandler.draw(game, board);
        if (!game.isFinished()){
            GameStatusHandler.mate(game, board);
            if (!game.isFinished()) {
                GameStatusHandler.check(game, board);
            }
        }
    }
    public Board getBoard() {
        return board;
    }

    public void setTarget(Piece target) {
        this.target = target;
    }
}
