package org.chessapp.utils;

import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.Cell;
import org.chessapp.piece.TakeOnPass;

public class TakeOnPassUtils {
    public static void clearTakeOnPass(Board board){
        for (Cell[] cells: board.getCells()) {
            for (Cell cell: cells) {
                TakeOnPass takeOnPass = cell.getTakeOnPass();
                if (takeOnPass != null) {
                    if (takeOnPass.isNew()) {
                        takeOnPass.setStatusOld();
                    }else {
                        cell.setTakeOnPass(null);
                    }
                }
            }
        }
    }
}
