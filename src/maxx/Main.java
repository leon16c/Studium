package maxx;

import maxx.domain.Game;
import maxx.logic.GameLogic;
import maxx.ui.GameUI;
import maxx.ui.InputProcessor;

public class Main {
    public static void main(String[] args) {
        Game game                       = new Game();
        GameLogic gameLogic             = new GameLogic(game);
        GameUI gameUI                   = new GameUI(game);
        InputProcessor inputProcessor   = new InputProcessor(gameLogic, gameUI);
        inputProcessor.processInput();
    }
}
