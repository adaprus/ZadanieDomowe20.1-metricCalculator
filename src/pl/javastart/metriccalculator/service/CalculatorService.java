package pl.javastart.metriccalculator.service;

import pl.javastart.metriccalculator.model.MetricValue;
import pl.javastart.metriccalculator.model.WeightValue;

public class CalculatorService {
    public void metersRecountInfo(double meters, MetricValue metricValue) {
        metricValue.setMeters(meters);
        metricValue.setCentimeters(100 * meters);
        metricValue.setMillimeters(1000 * meters);
    }

    public void centimetersRecountInfo(double centimeters, MetricValue metricValue) {
        metricValue.setMeters(centimeters / 100);
        metricValue.setCentimeters(centimeters);
        metricValue.setMillimeters(10 * centimeters);
    }

    public void millimetersRecountInfo(double millimeters, MetricValue metricValue) {
        metricValue.setMeters(millimeters / 1000);
        metricValue.setCentimeters(millimeters / 10);
        metricValue.setMillimeters(millimeters);
    }

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
