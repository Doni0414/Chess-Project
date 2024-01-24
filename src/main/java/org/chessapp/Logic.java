package org.chessapp;

import org.chessapp.piece.Pawn;
import org.chessapp.piece.Piece;

import java.util.List;

public class Logic {
    public static boolean blackTurn;
    public static Piece target;

    public static void logic(Board board, Piece piece, Coordinate dest){
        List<Coordinate> moves = piece.getMoves(board);
        List<Coordinate> eatMoves = piece.getEatMoves(board);
        if (moves.contains(dest) || eatMoves.contains(dest)){
            board.setPiece(null, piece.getCoordinate());
            board.setPiece(piece, dest);
            if (piece instanceof Pawn){
                if (!((Pawn) piece).isMoved()){
                    ((Pawn) piece).setMoved(true);
                }
            }
            board.repaint();
            Logic.blackTurn = !Logic.blackTurn;
        }
    }
}
