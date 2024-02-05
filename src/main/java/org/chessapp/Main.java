package org.chessapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.chessapp.game.Game;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.sidePane.GameStatusPane;
import org.chessapp.game.components.sidePane.SidePane;
import org.chessapp.piece.Knight;
import org.chessapp.piece.Bishop;
import org.chessapp.piece.King;
import org.chessapp.piece.Pawn;
import org.chessapp.piece.Rook;
import org.chessapp.piece.Queen;
import org.chessapp.utils.Coordinate;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board(Configuration.BOARD_WIDTH, Configuration.BOARD_HEIGHT);
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

        //Display black Knights
        Coordinate knightCoordinate1 = new Coordinate(1, 0);
        board.setPiece(new Knight(Color.BLACK, knightCoordinate1), knightCoordinate1);
        Coordinate knightCoordinate2 = new Coordinate(6, 0);
        board.setPiece(new Knight(Color.BLACK, knightCoordinate1), knightCoordinate2);

        //Display white Knights
        Coordinate knightCoordinate3 = new Coordinate(1, 7);
        board.setPiece(new Knight(Color.WHITE, knightCoordinate3), knightCoordinate3);
        Coordinate knightCoordinate4 = new Coordinate(6, 7);
        board.setPiece(new Knight(Color.WHITE, knightCoordinate4), knightCoordinate4);

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
        //Display queens
        Coordinate queenCoordinate1 = new Coordinate(3, 0);
        board.setPiece(new Queen(Color.BLACK, queenCoordinate1), queenCoordinate1);
        Coordinate queenCoordinate2 = new Coordinate(3, 7);
        board.setPiece(new Queen(Color.WHITE, queenCoordinate2), queenCoordinate2);
        //Display kings
        Coordinate kingCoordinate1 = new Coordinate(4, 0);
        board.setPiece(new King(Color.BLACK, kingCoordinate1), kingCoordinate1);

        Coordinate kingCoordinate2 = new Coordinate(4, 7);
        board.setPiece(new King(Color.WHITE, kingCoordinate2), kingCoordinate2);

        Game game = new Game(board, new SidePane());
        Scene scene = new Scene(game, Configuration.W, Configuration.BOARD_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Show board");
        stage.show();
    }
}
