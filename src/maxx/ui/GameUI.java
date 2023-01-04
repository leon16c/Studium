package maxx.ui;


import maxx.domain.Coordinates;
import maxx.domain.Game;


import java.util.ArrayList;

public class GameUI {
    private Game game;

    public GameUI(Game game) {
        this.game = game;
    }

    public void printPossibleMoves() {
        if (game.isWhitesTurn()) System.out.println("White, what is your move?");
        else System.out.println("Black, what is your move?");
        System.out.println();
        String s = "n ; e ; s ; w ; ";
        if (game.getCurrentPlayer().equals(game.getPlayerWhite())) s += "ne";
        else if (game.getCurrentPlayer().equals(game.getPlayerBlack())) s += "sw";
        System.out.println(s);
    }

    public void printBoard() {
        int whiteX = this.game.getPlayerWhite().getCurrentCoords().getX();
        int whiteY = this.game.getPlayerWhite().getCurrentCoords().getY();
        int blackX = this.game.getPlayerBlack().getCurrentCoords().getX();
        int blackY = this.game.getPlayerBlack().getCurrentCoords().getY();

        for (int i = 0; i < 8; i++) {
            ArrayList<String> tops = new ArrayList<>();
            ArrayList<String> mids = new ArrayList<>();
            ArrayList<String> bots = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                if( i == whiteX && j == whiteY ) {
                    tops.add("");
                    mids.add("W");
                    bots.add("");
                } else if (i == blackX && j == blackY) {
                    tops.add("");
                    mids.add("B");
                    bots.add("");
                } else if (!game.getBoard().getField(new Coordinates(i, j)).hasValue()) {
                    tops.add("");
                    mids.add("");
                    bots.add("");
                }   else {
                    tops.add(this.game.getBoard().getField(new Coordinates(i, j)).getValueString().split("/")[0]);
                    mids.add("---");
                    bots.add(this.game.getBoard().getField(new Coordinates(i, j)).getValueString().split("/")[1]);
                }

            }
            for (String s : tops) { System.out.printf("%10s", s); }
            System.out.print("\n");
            for (String s : mids) { System.out.printf("%10s", s); }
            System.out.print("\n");
            for (String s : bots) { System.out.printf("%10s", s); }
            System.out.print("\n\n\n");
        }
    }

    public void printScores() {
        System.out.println("Score White: " + this.game.getPlayerWhite().getScore() + " ; Score Black: " + this.game.getPlayerBlack().getScore());
    }


}
