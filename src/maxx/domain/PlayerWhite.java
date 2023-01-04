package maxx.domain;

public class PlayerWhite extends Player {
    public PlayerWhite() {
        super();
        super.color = "W";
    }

    @Override
    public Coordinates getCurrentCoords() {
        return super.getCurrentCoords();
    }

    @Override
    public double getScore() {
        return super.getScore();
    }

    @Override
    public void setCurrentCoords(Coordinates currentCoords) {
        super.setCurrentCoords(currentCoords);
    }

    @Override
    public boolean equals(Player other) {
        return super.equals(other);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void absorbFraction(Fraction fraction) {
        super.absorbFraction(fraction);
    }
}
