package com.quantity;

enum WeightUnit {
    KG(1.0), GRAM(0.001), POUND(0.453592);
    private final double factor;
    WeightUnit(double f) { this.factor = f; }
    public double toBase(double v) { return v * factor; }
    public double fromBase(double bv) { return bv / factor; }
}

class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double v, WeightUnit u) {
        this.value = v;
        this.unit = u;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof QuantityWeight)) return false;
        QuantityWeight that = (QuantityWeight) obj;
        return Math.abs(this.unit.toBase(this.value) - that.unit.toBase(that.value)) < 0.001;
    }

    public static QuantityWeight add(QuantityWeight w1, QuantityWeight w2, WeightUnit target) {
        double sum = w1.unit.toBase(w1.value) + w2.unit.toBase(w2.value);
        return new QuantityWeight(target.fromBase(sum), target);
    }
}

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC9: Weight Measurements ---");
        
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KG);
        QuantityWeight grams = new QuantityWeight(1000.0, WeightUnit.GRAM);
        
        System.out.println("1 kg == 1000 g: " + kg.equals(grams));
        
        QuantityWeight sum = QuantityWeight.add(kg, new QuantityWeight(1.0, WeightUnit.POUND), WeightUnit.KG);
        System.out.println("1 kg + 1 lb = " + sum.equals(new QuantityWeight(1.453592, WeightUnit.KG)));
    }
}
