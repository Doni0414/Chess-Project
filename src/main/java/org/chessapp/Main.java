package org.chessapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.Rook;

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

        //Set black rooks
        Coordinate rookCoordinate1 = new Coordinate(0, 0);
        board.setPiece(new Rook(Color.BLACK, rookCoordinate1), rookCoordinate1);
        Coordinate rookCoordinate2 = new Coordinate(7, 0);
        board.setPiece(new Rook(Color.BLACK, rookCoordinate2), rookCoordinate2);

        //Set white rooks
        Coordinate rookCoordinate3 = new Coordinate(0, 7);
        board.setPiece(new Rook(Color.WHITE, rookCoordinate3), rookCoordinate3);
        Coordinate rookCoordinate4 = new Coordinate(7, 7);
        board.setPiece(new Rook(Color.WHITE, rookCoordinate4), rookCoordinate4);

        Scene scene = new Scene(board, Configuration.W, Configuration.H);
        stage.setScene(scene);
        stage.setTitle("Show board");
        stage.show();
    }
}
