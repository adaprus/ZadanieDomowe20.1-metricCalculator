package service;

public class CalculatorService {
    public String metersRecountInfo(double meters){
        return "Metry: " + meters + "<br/>"
                + "Centymetry: " + (100 * meters) + "<br/>"
                + "Milimetry: " + (1000 * meters) + "<br/>";
    }

    public String centimetersRecountInfo(double centimeters){
        return "Metry: " + (centimeters / 100) + "<br/>"
                + "Centymetry: " + centimeters + "<br/>"
                + "Milimetry: " + (10 * centimeters) + "<br/>";
    }

    public String millimetersRecountInfo(double millimeters){
        return "Metry: " + (millimeters / 1000) + "<br/>"
                + "Centymetry: " + (millimeters / 10) + "<br/>"
                + "Milimetry: " + millimeters + "<br/>";
    }
}
