package pl.javastart.metriccalculator.model;

public class MetricValue {
    private double meters;
    private double centimeters;
    private double millimeters;

    public double getMeters() {
        return meters;
    }

    public void setMeters(double meters) {
        this.meters = meters;
    }

    public double getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(double centimeters) {
        this.centimeters = centimeters;
    }

    public double getMillimeters() {
        return millimeters;
    }

    public void setMillimeters(double millimeters) {
        this.millimeters = millimeters;
    }

    @Override
    public String toString() {
        return "Metry: " + meters + "<br/>"
                + "Centymetry: " + centimeters + "<br/>"
                + "Milimetry: " + millimeters + "<br/>";
    }
}
