package org.chessapp;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.chessapp.piece.Piece;

public class Cell extends StackPane {
    private Rectangle rectangle;
    private Coordinate coordinate;
    private Piece piece;

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
}
