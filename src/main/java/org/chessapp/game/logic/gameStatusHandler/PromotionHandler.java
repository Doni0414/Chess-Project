package org.chessapp.game.logic.gameStatusHandler;

import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.chessapp.game.Game;
import org.chessapp.game.components.board.Board;
import org.chessapp.game.components.board.Cell;
import org.chessapp.game.logic.gameStatusChecker.PromotionChecker;
import org.chessapp.piece.*;
import org.chessapp.utils.Coordinate;

import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PromotionHandler implements Runnable {
    private Game game;
    private Board board;
    private Pawn pawn;

    public PromotionHandler(Game game, Board board, Pawn pawn) {
        this.game = game;
        this.board = board;
        this.pawn = pawn;
    }

    @Override
    public void run() {
        try {
            System.out.println("Promotion pawn coordinate: " + pawn.getCoordinate());
            game.setPaused(true);
            Thread thread = new Thread(
                    new PromotionChooser(this, game, board, pawn)
            );
            game.setPaused(true);
            thread.start();
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class PromotionChooser implements Runnable {
    public static final double CELL_WIDTH = 60;
    public static final double CELL_HEIGHT = 60;
    public static final Color CELL_COLOR = Color.rgb(234, 182, 118);
    private PromotionHandler handler;
    private Game game;
    private Board board;
    private Pawn pawn;
    private GridPane grid;

    public PromotionChooser(PromotionHandler handler, Game game, Board board, Pawn pawn) {
        this.handler = handler;
        this.board = board;
        this.pawn = pawn;
        this.grid = new GridPane();
        Color color = pawn.isBlack() ? Color.BLACK : Color.WHITE;
        Cell rookCell = new Cell(CELL_WIDTH, CELL_HEIGHT, CELL_COLOR, new Coordinate(0, 0));
        rookCell.setPiece(new Rook(color, new Coordinate(0, 0)));
        Cell knightCell = new Cell(CELL_WIDTH, CELL_HEIGHT, CELL_COLOR, new Coordinate(0, 0));
        knightCell.setPiece(new Knight(color, new Coordinate(0, 0)));
        Cell bishopCell = new Cell(CELL_WIDTH, CELL_HEIGHT, CELL_COLOR, new Coordinate(0, 0));
        bishopCell.setPiece(new Bishop(color, new Coordinate(0, 0)));
        Cell queenCell = new Cell(CELL_WIDTH, CELL_HEIGHT, CELL_COLOR, new Coordinate(0, 0));
        queenCell.setPiece(new Queen(color, new Coordinate(0, 0)));

        grid.add(rookCell, 0, 0);
        grid.add(knightCell, 0, 1);
        grid.add(bishopCell, 0, 2);
        grid.add(queenCell, 0, 3);

        rookCell.setOnMouseClicked(e -> {
            board.setPiece(rookCell.getPiece(), pawn.getCoordinate());
            board.getChildren().remove(grid);
            game.setPaused(false);
        });
        knightCell.setOnMouseClicked(e -> {
            board.setPiece(knightCell.getPiece(), pawn.getCoordinate());
            Cell cell = board.getCell(pawn.getCoordinate());
            cell.setPiece(knightCell.getPiece());
            board.getChildren().remove(grid);
            game.setPaused(false);
        });
        bishopCell.setOnMouseClicked(e -> {
            board.setPiece(bishopCell.getPiece(), pawn.getCoordinate());
            Cell cell = board.getCell(pawn.getCoordinate());
            cell.setPiece(bishopCell.getPiece());
            board.getChildren().remove(grid);
            game.setPaused(false);
        });
        queenCell.setOnMouseClicked(e -> {
            board.setPiece(queenCell.getPiece(), pawn.getCoordinate());
            Cell cell = board.getCell(pawn.getCoordinate());
            cell.setPiece(queenCell.getPiece());
            board.getChildren().remove(grid);
            game.setPaused(false);
        });
    }

    @Override
    public void run() {
        System.out.println("Run Promotion chooser");
        Coordinate coordinate = pawn.getCoordinate();

        double padX = coordinate.getX() < 4 ? 0 : -CELL_WIDTH;
        double padY = coordinate.getY() < 4 ? 0 : -4 * CELL_HEIGHT;

        Cell cell = board.getCell(coordinate);
        double centerX = cell.getLayoutX() + cell.getCellWidth() / 2;
        double centerY = cell.getLayoutY() + cell.getCellHeight() / 2;

        Platform.runLater(() -> {
            board.getChildren().add(grid);
            grid.setLayoutX(centerX + padX);
            grid.setLayoutY(centerY + padY);
        });
    }
}
