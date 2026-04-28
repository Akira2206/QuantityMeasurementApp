package com.quantity;

enum LengthUnit {
    FEET(12.0), INCHES(1.0), YARD(36.0), CM(0.393701);
    private final double factor;
    LengthUnit(double f) { this.factor = f; }

    public double toBase(double value) { return value * factor; }
    public double fromBase(double baseValue) { return baseValue / factor; }
}

class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double v, LengthUnit u) {
        this.value = v;
        this.unit = u;
    }

    public double getBaseValue() { return unit.toBase(value); }

    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit target) {
        double sum = q1.getBaseValue() + q2.getBaseValue();
        return new QuantityLength(target.fromBase(sum), target);
    }
}

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC8: Refactored Unit Delegation ---");
        QuantityLength q = new QuantityLength(1, LengthUnit.YARD);
        System.out.println("1 Yard converted to base through Enum: " + q.getBaseValue());
    }
}
