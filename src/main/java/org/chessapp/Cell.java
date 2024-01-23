package org.chessapp;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
    private Rectangle rectangle;

    public Cell(double width, double height, Color color){
        this.rectangle = new Rectangle(width, height);
        this.rectangle.setFill(color);
        getChildren().add(rectangle);
    }
}
