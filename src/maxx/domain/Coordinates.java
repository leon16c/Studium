package maxx.domain;

public class Coordinates {
    private final int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean equals(Coordinates other) {
        if (this.getX() == other.getX() && this.getY() == other.getY()) return true;
        else return false;
    }
}
