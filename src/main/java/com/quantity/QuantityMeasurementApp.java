package com.quantity;

enum LengthUnit {
    FEET(12.0), INCHES(1.0), YARD(36.0), CM(0.393701);

    public final double conversionFactor;
    LengthUnit(double factor) { this.conversionFactor = factor; }
}

class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof QuantityLength)) return false;
        QuantityLength that = (QuantityLength) obj;
        return Math.abs((this.value * this.unit.conversionFactor) - 
                        (that.value * that.unit.conversionFactor)) < 0.001;
    }
}

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC4: Extended Units (Yards & CM) ---");
        
        QuantityLength oneYard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength threeFeet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength oneCm = new QuantityLength(1.0, LengthUnit.CM);
        
        System.out.println("1 yard == 3 feet: " + oneYard.equals(threeFeet));
        System.out.println("1 cm matches inches factor: " + oneCm.equals(new QuantityLength(0.393701, LengthUnit.INCHES)));
    }
}
