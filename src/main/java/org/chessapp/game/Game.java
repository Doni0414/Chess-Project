package org.chessapp.game;

import javafx.scene.layout.HBox;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.sidePane.GameStatusPane;
import org.chessapp.game.components.sidePane.SidePane;
import org.chessapp.game.logic.Logic;

public class Game extends HBox {
    private final Board board;
    private final SidePane sidePane;
    private boolean isStarted;
    private boolean isFinished;
    private boolean blackTurn;
    private boolean paused;
    private final Logic logic;

    public Game(Board board, SidePane sidePane){
        getChildren().addAll(board, sidePane);
        this.board = board;
        this.sidePane = sidePane;
        this.logic = new Logic(this, board);
    }

    public Logic getLogic() {
        return logic;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isBlackTurn() {
        return blackTurn;
    }

    public void setBlackTurn(boolean blackTurn) {
        this.blackTurn = blackTurn;
    }

    public Board getBoard() {
        return board;
    }

    public SidePane getSidePane() {
        return sidePane;
    }

    public void setStatus(String text){
        GameStatusPane statusPane = getSidePane().getGameStatusPane();
        statusPane.setText(text);
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
