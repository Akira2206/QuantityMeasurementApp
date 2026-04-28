package com.quantity;

enum LengthUnit {
    FEET(12.0), INCHES(1.0), YARD(36.0), CM(0.393701);
    public final double conversionFactor;
    LengthUnit(double factor) { this.conversionFactor = factor; }
}

class QuantityLength {
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (!Double.isFinite(value)) return 0.0;
        return (value * source.conversionFactor) / target.conversionFactor;
    }
}

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC5: Unit-to-Unit Conversion ---");
        
        double result = QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.INCHES);
        System.out.println("1 Yard to Inches: " + result);
        
        double cmToFeet = QuantityLength.convert(100.0, LengthUnit.CM, LengthUnit.FEET);
        System.out.println("100 cm to Feet: " + cmToFeet);
    }
}
