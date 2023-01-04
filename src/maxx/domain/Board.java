package maxx.domain;

import java.util.Random;

public class Board {
    private Field[][] fields;

    public Board() {
        randomizeAllFields();
    }

    public Field getField(Coordinates coordinates) {
        return fields[coordinates.getX()][coordinates.getY()];
    }

    // only used in Board()
    private void randomizeAllFields() {
        this.fields = new Field[8][8];
        for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) {
            fields[i][j] = new Field();
            fields[i][j].setFraction(randomFraction());
        }
    }

    // only used in randomizeAllFields()
    private Fraction randomFraction() {
        Random random = new Random();
        int randomNumerator = random.nextInt(11, 1000);
        int randomDenominator = random.nextInt(10, randomNumerator);
        while (Fraction.gcd(randomNumerator, randomDenominator) != 1) randomDenominator = random.nextInt(10, randomNumerator);
        Fraction randomFraction = new Fraction(randomNumerator, randomDenominator);
        return randomFraction;
    }
}
