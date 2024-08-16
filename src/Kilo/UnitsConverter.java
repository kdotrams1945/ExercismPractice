package Kilo;

public class UnitsConverter implements Converter {
    @Override
    public double kiloToPound(double kilo) {
        if (kilo < 0)
            throw new IllegalArgumentException("Negative weight is invalid.");
        return kilo * 2.20462;
    }
}
