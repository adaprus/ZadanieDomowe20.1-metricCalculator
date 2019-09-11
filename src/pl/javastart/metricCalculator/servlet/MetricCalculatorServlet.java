package pl.javastart.metricCalculator.servlet;

import pl.javastart.metricCalculator.model.MetricValue;
import pl.javastart.metricCalculator.model.WeightValue;
import pl.javastart.metricCalculator.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/metriccalc")
public class MetricCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            String nonEmptyParameterName;
            String info;

            if (checkIfOnlyOneParameterIsWritten(parameterMap)) {
                nonEmptyParameterName = (getNonEmptyParameterKey(parameterMap));
                String[] nonEmptyParameterValues = parameterMap.get(nonEmptyParameterName);
                String value = nonEmptyParameterValues[0];

                info = nonEmptyParameterInfo(nonEmptyParameterName, value);
            } else {
                info = "Wpisz jedną wartość";
            }
            writer.println(info);
        } catch (NumberFormatException e) {
            writer.println("Niepoprawny typ danych");
        }
    }

    private boolean checkIfOnlyOneParameterIsWritten(Map<String, String[]> map) {
        int counter = 0;
        Set<Map.Entry<String, String[]>> entrySet = map.entrySet();

        for (Map.Entry<String, String[]> s : entrySet) {
            String[] value = s.getValue();
            if (!(s.getValue() == null) && !value[0].equals("")) {
                counter++;
            }
        }
        return counter == 1;
    }

    private String getNonEmptyParameterKey(Map<String, String[]> map) {
        Set<Map.Entry<String, String[]>> entrySet = map.entrySet();
        String parameterKey = null;

        for (Map.Entry<String, String[]> s : entrySet) {
            String[] value = s.getValue();
            if (!(s.getValue() == null) && !value[0].equals("")) {
                parameterKey = s.getKey();
            }
        }
        return parameterKey;
    }

    private String nonEmptyParameterInfo(String nonEmptyParameterName, String value) {
        MetricValue metricValue;
        WeightValue weightValue;
        String info = null;
        CalculatorService service = new CalculatorService();

        switch (nonEmptyParameterName) {
            case "meters":
                double meters = (Double.parseDouble(value));
                metricValue = new MetricValue();
                service.metersRecountInfo(meters, metricValue);
                info = metricValue.toString();
                break;
            case "centimeters":
                double centimeters = (Double.parseDouble(value));
                metricValue = new MetricValue();
                service.centimetersRecountInfo(centimeters, metricValue);
                info = metricValue.toString();
                break;
            case "millimeters":
                double millimeters = (Double.parseDouble(value));
                metricValue = new MetricValue();
                service.millimetersRecountInfo(millimeters, metricValue);
                info = metricValue.toString();
                break;
            case "kilograms":
                double kilograms = Double.parseDouble(value);
                weightValue = new WeightValue();
                service.kilogramsRecountInfo(kilograms, weightValue);
                info = weightValue.toString();
                break;
            case "grams":
                double grams = Double.parseDouble(value);
                weightValue = new WeightValue();
                service.gramsRecountInfo(grams, weightValue);
                info = weightValue.toString();
                break;
            case "milligrams":
                double milligrams = Double.parseDouble(value);
                weightValue = new WeightValue();
                service.milligramsRecountInfo(milligrams, weightValue);
                info = weightValue.toString();
                break;
        }
        return info;
    }
}
