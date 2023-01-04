package maxx.domain;

import java.util.Random;

public class Game {
    private Board board;
    private PlayerWhite playerWhite;
    private PlayerBlack playerBlack;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
        createPlayers();
        this.currentPlayer = this.playerWhite;
    }

    public void createPlayers() {
        this.playerWhite = new PlayerWhite();
        this.playerBlack = new PlayerBlack();

        Random random = new Random();
        Coordinates coordsWhite = new Coordinates(random.nextInt(8), random.nextInt(8));
        Coordinates coordsBlack = new Coordinates(random.nextInt(8), random.nextInt(8));
        while (coordsBlack.equals(coordsWhite)) coordsBlack = new Coordinates(random.nextInt(8), random.nextInt(8));
        playerWhite.setCurrentCoords(coordsWhite);
        playerBlack.setCurrentCoords(coordsBlack);
        getBoard().getField(coordsWhite).use();
        getBoard().getField(coordsBlack).use();
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerWhite getPlayerWhite() {
        return playerWhite;
    }

    public PlayerBlack getPlayerBlack() {
        return playerBlack;
    }

    public boolean isWhitesTurn() {
        return this.getCurrentPlayer().equals(this.getPlayerWhite());
    }

    public void switchCurrentPlayer() {
        if (isWhitesTurn()) currentPlayer = playerBlack;
        else  currentPlayer = playerWhite;
    }
}
