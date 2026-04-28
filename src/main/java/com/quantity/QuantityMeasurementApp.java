package com.quantity;

enum LengthUnit {
    FEET(12.0), INCHES(1.0), YARD(36.0), CM(0.393701);
    public final double factor;
    LengthUnit(double f) { this.factor = f; }
}

class QuantityLength {
    public final double value;
    public final LengthUnit unit;

    public QuantityLength(double v, LengthUnit u) {
        this.value = v;
        this.unit = u;
    }

    public static QuantityLength add(QuantityLength l1, QuantityLength l2) {
        double sumInBase = (l1.value * l1.unit.factor) + (l2.value * l2.unit.factor);
        double resultValue = sumInBase / l1.unit.factor;
        return new QuantityLength(resultValue, l1.unit);
    }
}

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC6: Addition of Two Length Units ---");
        
        QuantityLength l1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12.0, LengthUnit.INCHES);
        
        QuantityLength result = QuantityLength.add(l1, l2);
        System.out.println("Addition result (1 ft + 12 in): " + result.value + " " + result.unit);
    }
}
