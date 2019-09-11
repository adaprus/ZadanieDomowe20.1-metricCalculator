package pl.javastart.metricCalculator.model;

public class WeightValue {
    private double kilograms;
    private double grams;
    private double milligrams;

    public double getKilograms() {
        return kilograms;
    }

    public void setKilograms(double kilograms) {
        this.kilograms = kilograms;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }

    public double getMilligrams() {
        return milligrams;
    }

    public void setMilligrams(double milligrams) {
        this.milligrams = milligrams;
    }

    @Override
    public String toString() {
        return "Kilogramy: " + kilograms + "<br/>"
                + "Gramy: " + grams + "<br/>"
                + "Miligramy: " + milligrams + "<br/>";
    }
}
