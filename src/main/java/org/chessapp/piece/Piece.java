package org.chessapp.piece;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.chessapp.game.components.board.Board;
import org.chessapp.move.Move;
import org.chessapp.utils.Coordinate;

import java.util.List;

public abstract class Piece extends Label {
    protected Coordinate coordinate;
    protected Color color;
    protected boolean moved;

    public Piece(char c, Color color, Coordinate coordinate){
        setText(c + "");
        setCoordinate(coordinate);
        setColor(color);
        setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public boolean isBlack(){
        return getColor().equals(Color.BLACK);
    }
    public boolean isWhite(){
        return getColor().equals(Color.WHITE);
    }

    public abstract List<Move> getMoves(Board board);
    public abstract List<Move> getEatMoves(Board board);
    public abstract List<Coordinate> getAttackedCoordinates(Board board);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    @Override
    public Piece clone() {
        try {
            Piece clone = (Piece) super.clone();
            return clone;
        }catch (CloneNotSupportedException ex){
            throw new AssertionError();
        }
    }
}
