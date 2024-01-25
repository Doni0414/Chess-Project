package org.chessapp;

import javafx.scene.layout.HBox;

public class Game extends HBox {
    public Game(Board board, GameStatusPane statusPane){
        getChildren().addAll(board, statusPane);
    }
}
