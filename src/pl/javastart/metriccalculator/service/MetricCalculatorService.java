package pl.javastart.metriccalculator.service;
import pl.javastart.metriccalculator.model.MetricValue;

public class MetricCalculatorService {
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
}
