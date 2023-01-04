package maxx.domain;

public class Move {
    private Player player;
    private Coordinates startCoords;
    private Coordinates endCoords;

    public Move(Player player, Coordinates startCoords, Coordinates endCoords) {
        this.player = player;
        this.startCoords = startCoords;
        this.endCoords = endCoords;
    }

    public Player getPlayer() {
        return player;
    }

    public Coordinates getStartCoords() {
        return startCoords;
    }

    public Coordinates getEndCoords() {
        return endCoords;
    }
}
