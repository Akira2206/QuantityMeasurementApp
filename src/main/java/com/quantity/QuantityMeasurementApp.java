package com.quantity;

public class QuantityMeasurementApp {
    public static boolean compareFeet(double feet1, double feet2) {
        return Double.compare(feet1, feet2) == 0;
    }

    public static void main(String[] args) {
        System.out.println("--- UC1: Feet Measurement Equality ---");
        
        double firstValue = 3.0;
        double secondValue = 3.0;
        
        boolean result = compareFeet(firstValue, secondValue);
        System.out.println(firstValue + " ft == " + secondValue + " ft: " + result);
    }
}
