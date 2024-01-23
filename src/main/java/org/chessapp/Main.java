package org.chessapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.chessapp.piece.Bishop;
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

        //Display black bishops
        Coordinate bishopCoordinate1 = new Coordinate(2, 0);
        board.setPiece(new Bishop(Color.BLACK, bishopCoordinate1), bishopCoordinate1);
        Coordinate bishopCoordinate2 = new Coordinate(5, 0);
        board.setPiece(new Bishop(Color.BLACK, bishopCoordinate1), bishopCoordinate2);

        //Display white bishops
        Coordinate bishopCoordinate3 = new Coordinate(2, 7);
        board.setPiece(new Bishop(Color.WHITE, bishopCoordinate3), bishopCoordinate3);
        Coordinate bishopCoordinate4 = new Coordinate(5, 7);
        board.setPiece(new Bishop(Color.WHITE, bishopCoordinate4), bishopCoordinate4);

        Scene scene = new Scene(board, Configuration.W, Configuration.H);
        stage.setScene(scene);
        stage.setTitle("Show board");
        stage.show();
    }
}
