package maxx.logic;

import maxx.domain.*;

public class GameLogic {
    private Game game;

    public GameLogic(Game game) {
        this.game = game;
    }

    public void processMove(String input) {
        Player player = game.getCurrentPlayer();
        Coordinates start = player.getCurrentCoords();
        Coordinates end;
        switch (input) {
            default:
                System.out.println("Invalid direction");
                break;
            case "n":
                end = new Coordinates(start.getX() - 1, start.getY());
                makeMove(new Move(player, start, end));
                break;
            case "e":
                end = new Coordinates(start.getX(), start.getY() + 1);
                makeMove(new Move(player, start, end));
                break;
            case "s":
                end = new Coordinates(start.getX() + 1, start.getY());
                makeMove(new Move(player, start, end));
                break;
            case "w":
                end = new Coordinates(start.getX(), start.getY() - 1);
                makeMove(new Move(player, start, end));
                break;
            case "ne":
                if (!game.isWhitesTurn()) {
                    System.out.println("Only white can move like this!");
                    break;
                }
                end = new Coordinates(start.getX() - 1, start.getY() + 1);
                makeMove(new Move(player, start, end));
                break;
            case "sw":
                if (game.isWhitesTurn()) {
                    System.out.println("Only black can move like this!");
                    break;
                }
                end = new Coordinates(start.getX() + 1, start.getY() - 1);
                makeMove(new Move(player, start, end));
                break;
        }
    }

    public boolean makeMove(Move move) {
        Player player = move.getPlayer();
        Coordinates startCoords = move.getStartCoords();
        Coordinates endCoords = move.getEndCoords();
        if (startCoords.getX() < 0 || startCoords.getX() > 7 || startCoords.getY() < 0 || startCoords.getY() > 7) {
            System.out.println("Invalid start coordinates");
            return false; // never happened
        }
        if (endCoords.getX() < 0 || endCoords.getX() > 7 || endCoords.getY() < 0 || endCoords.getY() > 7) {
            System.out.println("Invalid end coordinates");
            return false;
        }
        if (endCoords.equals(game.getPlayerWhite().getCurrentCoords()) || endCoords.equals(game.getPlayerBlack().getCurrentCoords())) {
            System.out.println("Invalid move, already occupied by other player");
            return false;
        }
        if (!startCoords.equals(player.getCurrentCoords())) {
            System.out.println("Coordinate mismatch");
            return false; // never happened
        }
        player.setCurrentCoords(endCoords);
        Field target = game.getBoard().getField(endCoords);
        if (target.hasValue()) player.absorbFraction(target.getValue());
        target.use();
        game.switchCurrentPlayer();
        return true;
    }


    public boolean endGameIfWinner() {
        double scoreWhite = game.getPlayerWhite().getScore();
        double scoreBlack = game.getPlayerBlack().getScore();
        if (scoreWhite >= 55) {
            System.out.println("We have a winner!");
            System.out.println("White has won the game with " + scoreWhite + " points.");
            System.out.println("Black has come in second with " + scoreBlack + " points.");
            System.out.println("That's a difference of " + (scoreWhite-scoreBlack) + " points!");
            return true;
        }
        if (scoreBlack >= 55) {
            System.out.println("Black has won the game with " + scoreBlack + " points.");
            System.out.println("White has come in second with " + scoreWhite + " points.");
            System.out.println("That's a difference of " + (scoreBlack-scoreWhite) + " points!");
            return true;
        }
        return false;
    }
}
