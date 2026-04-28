package com.quantity;

public class QuantityMeasurementApp {
    public static boolean validateFeet(double feet1, double feet2) {
        return Double.compare(feet1, feet2) == 0;
    }

    public static boolean validateInches(double in1, double in2) {
        return Double.compare(in1, in2) == 0;
    }

    public static void main(String[] args) {
        System.out.println("--- UC2: Feet and Inches Equality ---");
        System.out.println("0.0 ft == 0.0 ft: " + validateFeet(0.0, 0.0));
        System.out.println("12.0 in == 12.0 in: " + validateInches(12.0, 12.0));
    }
}
