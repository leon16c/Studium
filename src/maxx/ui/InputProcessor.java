package maxx.ui;

import maxx.logic.GameLogic;

import java.util.Scanner;

public class InputProcessor {
    private GameLogic gameLogic;
    private GameUI gameUI;
    private Scanner scanner;

    public InputProcessor(GameLogic gameLogic, GameUI gameUI) {
        this.gameLogic = gameLogic;
        this.gameUI = gameUI;
        scanner = new Scanner(System.in);
    }

    public void processInput() {
        while (true) {
            gameUI.printBoard();
            gameUI.printScores();
            gameUI.printPossibleMoves();
            String input = scanner.nextLine();
            if (input == null) input = "X";
            gameLogic.processMove(input);
            if (gameLogic.endGameIfWinner()) break;
        }
    }


}
