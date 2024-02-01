package org.chessapp.game.logic;

import javafx.scene.paint.Color;
import org.chessapp.*;
import org.chessapp.game.Game;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.BoardPainter;
import org.chessapp.game.components.board.Cell;
import org.chessapp.game.components.sidePane.GameStatusPane;
import org.chessapp.piece.King;
import org.chessapp.piece.Piece;
import org.chessapp.utils.Coordinate;

import java.util.List;

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
                    setTarget(piece);
                    BoardPainter.paintMoves(board, piece);
                    BoardPainter.paintEatMoves(board, piece);
                }else if(target != null){

                }
            }else if(target != null){

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
