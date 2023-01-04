package maxx.domain;

import java.math.BigInteger;

public class Fraction {

    private final BigInteger numerator, denominator;

    public Fraction(String numerator, String denominator) {
        BigInteger _numerator = new BigInteger(numerator);
        BigInteger _denominator = new BigInteger(denominator);
        BigInteger gcd = _numerator.gcd(_denominator);
        this.numerator = _numerator.divide(gcd);
        this.denominator = _denominator.divide(gcd);
    }

    public Fraction(BigInteger numerator, BigInteger denominator) {
        this(numerator.toString(), denominator.toString());
    }

    public Fraction(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }


    public double value() {
        return Double.valueOf(numerator.toString()) / Double.valueOf(denominator.toString());
    }

    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
