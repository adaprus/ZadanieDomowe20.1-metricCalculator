package pl.javastart.metriccalculator.service;

import pl.javastart.metriccalculator.model.WeightValue;

public class WeightCalculatorService {
    public void kilogramsRecountInfo(double kilograms, WeightValue weightValue) {
        weightValue.setKilograms(kilograms);
        weightValue.setGrams(1000 * kilograms);
        weightValue.setMilligrams(1_000_000 * kilograms);
    }

    public void gramsRecountInfo(double grams, WeightValue weightValue) {
        weightValue.setKilograms(grams / 1000);
        weightValue.setGrams(grams);
        weightValue.setMilligrams(1000 * grams);
    }

    public void milligramsRecountInfo(double milligrams, WeightValue weightValue) {
        weightValue.setKilograms(milligrams / 1_000_000);
        weightValue.setGrams(milligrams / 1000);
        weightValue.setMilligrams(milligrams);
    }
}
