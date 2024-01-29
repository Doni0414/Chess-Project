package org.chessapp;

import javafx.scene.paint.Color;
import org.chessapp.piece.King;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.Piece;
import org.chessapp.piece.TakeOnPass;

import java.util.List;

public class Logic {
    private boolean blackTurn;
    private boolean isFinished;
    private Piece target;
    private final Board board;

    public Logic(Board board){
        this.board = board;
        board.setLogic(this);
    }

    public void logic(Cell cell){
        if (!isFinished){
            Piece piece = cell.getPiece();
            if (piece != null){
                if (piece.isBlack() == blackTurn){
                    board.repaint();
                    target = piece;
                    board.paintMoves(piece);
                    board.paintEatMoves(piece);
                }else if(target != null){

                }
            }else if(target != null){

            }
        }
    }
    public void move(Piece piece, Cell cell){
        board.setPiece(null, piece.getCoordinate());
        board.setPiece(piece, cell.getCoordinate());
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
    public static boolean isDraw(Board board){
        List<Piece> team = board.getTeam(blackTurn);
        for (Piece piece: team){
            List<Coordinate> moves = piece.getMoves(board);
            moves.addAll(piece.getEatMoves(board));
            if (moves.size() > 0){
                return false;
            }
        }
        String text = "Draw!";
        GameStatusPane.setText(text);
        isFinished = true;
        return true;
    }
    private static void clearTakeOnPass(Board board) {
        Cell[][] cells = board.getCells();
        for (int i = 0; i < Configuration.BOARD_ROWS; i++) {
            for (int j = 0; j < Configuration.BOARD_COLS; j++) {
                cells[i][j].setTakeOnPass(null);
            }
        }
    }

    public Board getBoard() {
        return board;
    }
}
