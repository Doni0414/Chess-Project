package org.chessapp;

public class ValidMove {
    public static boolean isValidMove(Coordinate coordinate){
        int x = coordinate.getX(), y = coordinate.getY();
        return x >= 0 && x < Configuration.BOARD_COLS && y >= 0 && y < Configuration.BOARD_ROWS;
    }
}
