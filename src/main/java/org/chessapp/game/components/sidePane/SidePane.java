package org.chessapp.game.components.sidePane;

import javafx.geometry.Side;
import javafx.scene.layout.VBox;

public class SidePane extends VBox {
    private final GameStatusPane gameStatusPane;
    public SidePane() {
        gameStatusPane = new GameStatusPane();
        getChildren().add(gameStatusPane);
    }

    public GameStatusPane getGameStatusPane() {
        return gameStatusPane;
    }
}
