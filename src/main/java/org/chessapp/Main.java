package org.chessapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.chessapp.piece.Knight;
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

        //Display black Knights
        Coordinate knightCoordinate1 = new Coordinate(1, 0);
        board.setPiece(new Knight(Color.BLACK, knightCoordinate1), knightCoordinate1);
        Coordinate knightCoordinate2 = new Coordinate(6, 0);
        board.setPiece(new Knight(Color.BLACK, knightCoordinate1), knightCoordinate2);

        //Display white Knights
        Coordinate knightCoordinate3 = new Coordinate(1, 7);
        board.setPiece(new Knight(Color.BLACK, knightCoordinate3), knightCoordinate3);
        Coordinate knightCoordinate4 = new Coordinate(6, 7);
        board.setPiece(new Knight(Color.BLACK, knightCoordinate4), knightCoordinate4);

        Scene scene = new Scene(board, Configuration.W, Configuration.H);
        stage.setScene(scene);
        stage.setTitle("Show board");
        stage.show();
    }
}
