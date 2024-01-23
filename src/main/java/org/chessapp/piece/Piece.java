package org.chessapp.piece;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.chessapp.Board;
import org.chessapp.Coordinate;

import java.util.List;

public abstract class Piece extends Label {
    private Coordinate coordinate;

    public Piece() {

    }

    public Piece(char c, Color color, Coordinate coordinate){
        setText(c + "");
        setTextFill(color);
        setCoordinate(coordinate);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public boolean isBlack(){
        return getTextFill().equals(Color.BLACK);
    }

    public abstract List<Coordinate> getMoves(Board board);
}
