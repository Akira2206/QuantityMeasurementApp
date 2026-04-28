package com.quantity;

enum LengthUnit {
    FEET(12.0), INCHES(1.0); // Base unit is Inches

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
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;
        QuantityLength that = (QuantityLength) obj;
        
        double v1 = this.value * this.unit.conversionFactor;
        double v2 = that.value * that.unit.conversionFactor;
        return Math.abs(v1 - v2) < 0.001;
    }
}

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC3: Generic Quantity Class (DRY) ---");
        
        QuantityLength oneFoot = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength twelveInches = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println("1 ft == 12 in: " + oneFoot.equals(twelveInches));
    }
}
