package org.chessapp.game.components.board;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.chessapp.utils.Coordinate;
import org.chessapp.piece.Piece;
import org.chessapp.piece.TakeOnPass;

public class Cell extends StackPane {
    private Rectangle rectangle;
    private Coordinate coordinate;
    private Piece piece;
    private TakeOnPass takeOnPass;

    public Cell(double width, double height, Color color, Coordinate coordinate){
        this.rectangle = new Rectangle(width, height);
        this.rectangle.setFill(color);
        getChildren().add(rectangle);
        setCoordinate(coordinate);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        if (this.piece != null){
            getChildren().remove(this.piece);
        }
        this.piece = piece;
        if (this.piece != null){
            getChildren().add(this.piece);
        }
    }

    public TakeOnPass getTakeOnPass() {
        return takeOnPass;
    }

    public void setTakeOnPass(TakeOnPass takeOnPass) {
        this.takeOnPass = takeOnPass;
    }

    public double getCellWidth() {
        return rectangle.getWidth();
    }
    public double getCellHeight() {
        return rectangle.getHeight();
    }
}
