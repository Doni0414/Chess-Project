package org.chessapp.utils;

import org.chessapp.Configuration;

public class ValidCoordinate {
    public static boolean isValidMove(Coordinate coordinate){
        int x = coordinate.getX(), y = coordinate.getY();
        return x >= 0 && x < Configuration.BOARD_COLS && y >= 0 && y < Configuration.BOARD_ROWS;
    }
}
