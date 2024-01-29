package org.chessapp;

import javafx.scene.layout.HBox;

public class Game extends HBox {
    private final GameStatusPane gameStatusPane;
    private final Logic logic;

    public Game(Board board, GameStatusPane statusPane){
        getChildren().addAll(board, statusPane);
        logic = new Logic(board);
        gameStatusPane = new GameStatusPane();
    }

    public Logic getLogic() {
        return logic;
    }

    public GameStatusPane getGameStatusPane() {
        return gameStatusPane;
    }
}
