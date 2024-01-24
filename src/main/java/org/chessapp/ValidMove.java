package org.chessapp;

public class ValidMove {
    public static boolean isValidMove(Coordinate coordinate){
        int x = coordinate.getX(), y = coordinate.getY();
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
