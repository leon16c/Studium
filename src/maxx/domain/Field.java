package maxx.domain;

public class Field {
    private Fraction value;
    private boolean hasValue;

    public Field() {
        this.hasValue = true;
    }
    public String getValueString() {
        return value.toString();
    }

    public void setFraction(Fraction fraction) {
        if (this.value != null) {
            System.out.println("Fraction already full");
            return;
        }
        this.value = fraction;
    }

    public Fraction getValue() {
        return value;
    }

    public boolean hasValue() {
        return hasValue;
    }

    public void use() {
        this.hasValue = false;
    }
}
