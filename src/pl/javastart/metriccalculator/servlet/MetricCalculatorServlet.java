package pl.javastart.metriccalculator.servlet;

import pl.javastart.metriccalculator.model.MetricValue;
import pl.javastart.metriccalculator.service.FormReadService;
import pl.javastart.metriccalculator.service.MetricCalculatorService;

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
    private MetricCalculatorService service = new MetricCalculatorService();
    private FormReadService formReadService = new FormReadService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String info;

        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            String nonEmptyParameterName;
            if (formReadService.checkIfOnlyOneParameterIsWritten(parameterMap)) {
                nonEmptyParameterName = (formReadService.getNonEmptyParameterKey(parameterMap));
                String[] nonEmptyParameterValues = parameterMap.get(nonEmptyParameterName);
                String value = nonEmptyParameterValues[0];

                info = nonEmptyMetricParameterInfo(nonEmptyParameterName, value);
            } else {
                info = "Wpisz jedną wartość";
            }
            writer.println(info);
        } catch (NumberFormatException e) {
            writer.println("Niepoprawny typ danych");
        }
    }



    private String nonEmptyMetricParameterInfo(String nonEmptyParameterName, String value) {
        MetricValue metricValue;
        String info = null;

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
        }
        return info;
    }
}
