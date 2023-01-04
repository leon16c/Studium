package maxx.domain;

import java.util.ArrayList;

public abstract class Player {
    protected String color;
    protected ArrayList<Fraction> score;
    protected Coordinates currentCoords;

    public Player() {
        this.score = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public double getScore() {
        double sum = 0;
        for (Fraction f : score) sum += f.value();
        return sum;
    }

    public void absorbFraction (Fraction fraction) {
        this.score.add(fraction);
    }

    public Coordinates getCurrentCoords() {
        return currentCoords;
    }

    public void setCurrentCoords(Coordinates currentCoords) {
        this.currentCoords = currentCoords;
    }

    public boolean equals(Player other) {
        return this.getColor().equals(other.getColor());
    }

    @Override
    public String toString() {
        return "Player{" +
                "color='" + color + '\'' +
                ", score=" + score +
                ", currentCoords=" + currentCoords +
                '}';
    }
}
