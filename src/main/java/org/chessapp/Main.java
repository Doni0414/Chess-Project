package org.chessapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.chessapp.piece.King;
import org.chessapp.piece.Pawn;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board(Configuration.W, Configuration.H);
        for (int i = 0; i < 8; i++) {
            Coordinate coordinate = new Coordinate(i, 1);
            board.setPiece(new Pawn(Color.BLACK, coordinate), coordinate);
        }
        for (int i = 0; i < 8; i++) {
            Coordinate coordinate = new Coordinate(i, 6);
            board.setPiece(new Pawn(Color.WHITE, coordinate), coordinate);
        }

        //Display kings
        Coordinate kingCoordinate1 = new Coordinate(4, 0);
        board.setPiece(new King(Color.BLACK, kingCoordinate1), kingCoordinate1);

        Coordinate kingCoordinate2 = new Coordinate(4, 7);
        board.setPiece(new King(Color.WHITE, kingCoordinate2), kingCoordinate2);

        Scene scene = new Scene(board, Configuration.W, Configuration.H);
        stage.setScene(scene);
        stage.setTitle("Show board");
        stage.show();
    }
}
