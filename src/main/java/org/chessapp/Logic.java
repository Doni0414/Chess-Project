package org.chessapp;

import org.chessapp.piece.Pawn;
import org.chessapp.piece.Piece;
import org.chessapp.piece.TakeOnPass;

import java.util.List;

public class Logic {
    public static boolean blackTurn;
    public static Piece target;

    public static void logic(Board board, Piece piece, Coordinate dest){
        List<Coordinate> moves = piece.getMoves(board);
        List<Coordinate> eatMoves = piece.getEatMoves(board);
        if (moves.contains(dest) || eatMoves.contains(dest)){
            board.setPiece(null, piece.getCoordinate());
            TakeOnPass takeOnPass = board.getCell(dest).getTakeOnPass();
            if (takeOnPass != null){
                board.setPiece(null, takeOnPass.getPawn().getCoordinate());
            }
                clearTakeOnPass(board);
            if (piece instanceof Pawn){
                if (!((Pawn) piece).isMoved()){
                    ((Pawn) piece).setMoved(true);
                    System.out.println(Math.abs(dest.getY() - piece.getCoordinate().getY()));
                    if (Math.abs(dest.getY() - piece.getCoordinate().getY()) == 2){
                        Coordinate newCoordinate = new Coordinate(dest.getX(), piece.isBlack() ? dest.getY() - 1 : dest.getY() + 1);
                        Cell cell = board.getCell(newCoordinate);
                        cell.setTakeOnPass(new TakeOnPass((Pawn) piece, newCoordinate));
                    }
                }
            }
            board.setPiece(piece, dest);
            board.repaint();
            Logic.blackTurn = !Logic.blackTurn;
        }
    }

    private static void clearTakeOnPass(Board board) {
        Cell[][] cells = board.getCells();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j].setTakeOnPass(null);
            }
        }
    }
}
