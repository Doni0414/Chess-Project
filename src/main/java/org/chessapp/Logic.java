package org.chessapp;

import javafx.scene.paint.Color;
import org.chessapp.piece.King;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.Piece;
import org.chessapp.piece.TakeOnPass;

import java.util.List;

public class Logic {
    public static boolean blackTurn;
    public static Piece target;
    public static boolean isFinished;

    public static boolean logic(Board board, Piece piece, Coordinate dest, boolean recover){
        List<Coordinate> moves = piece.getMoves(board);
        List<Coordinate> eatMoves = piece.getEatMoves(board);
        if (moves.contains(dest) || eatMoves.contains(dest)){
            Coordinate src = piece.getCoordinate();
            Piece destPiece = board.getCell(dest).getPiece();
            board.setPiece(null, piece.getCoordinate());
            TakeOnPass takeOnPass = (piece instanceof Pawn) ? board.getCell(dest).getTakeOnPass() : null;
            if (takeOnPass != null){
                board.setPiece(null, takeOnPass.getPawn().getCoordinate());
            }
            board.setPiece(piece, dest);

            boolean isCheck = isCheck(board);
            if (isCheck || recover){
                board.setPiece(piece, src);
                board.setPiece(destPiece, dest);
                if (takeOnPass != null){
                    board.setPiece(takeOnPass.getPawn(), takeOnPass.getPawn().getCoordinate());
                }
            }else{
                Logic.blackTurn = !Logic.blackTurn;
                clearTakeOnPass(board);
                if (piece instanceof Pawn){
                    if (!((Pawn) piece).isMoved()){
                        ((Pawn) piece).setMoved(true);
                        if (Math.abs(dest.getY() - src.getY()) == 2){
                            Coordinate newCoordinate = new Coordinate(dest.getX(), piece.isBlack() ? dest.getY() - 1 : dest.getY() + 1);
                            Cell cell = board.getCell(newCoordinate);
                            cell.setTakeOnPass(new TakeOnPass((Pawn) piece, newCoordinate));
                        }
                    }
                }
            }
            board.repaint();
            return isCheck;
        }
        return false;
    }
    public static boolean isCheck(Board board){
        List<Coordinate> attackedCoordinates = board.getAttackedCoordinates();
        for (Coordinate coordinate: attackedCoordinates){
            Piece piece = board.getCell(coordinate).getPiece();
            if (piece instanceof King && piece.isBlack() == blackTurn){
                board.paintCell(coordinate, Color.ORANGE);
                String text = blackTurn ? "Check for Black King" : "Check for White King";
                GameStatusPane.setText(text);
                return true;
            }
        }
        GameStatusPane.setText("Ongoing");
        return false;
    }
    public static boolean isMate(Board board){
        List<Piece> team = board.getTeam(blackTurn);
        for (Piece piece: team){
            List<Coordinate> moves = piece.getMoves(board);
            moves.addAll(piece.getEatMoves(board));
            for (Coordinate move: moves){
                if (!logic(board, piece, move, true)){
                    return false;
                }
            }
        }
        String text = blackTurn ? "Mate for Black King\nWhite wins!" : "Mate for White King\nBlack Wins";
        GameStatusPane.setText(text);
        isFinished = true;
        return true;
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
