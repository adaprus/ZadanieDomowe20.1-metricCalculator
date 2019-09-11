package pl.javastart.metriccalculator.servlet;

import pl.javastart.metriccalculator.model.WeightValue;
import pl.javastart.metriccalculator.service.FormReadService;
import pl.javastart.metriccalculator.service.WeightCalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/weightcalc")
public class WeightCalculatorServlet extends HttpServlet {
    private WeightCalculatorService service = new WeightCalculatorService();
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

                info = nonEmptyWeightParameterInfo(nonEmptyParameterName, value);
            } else {
                info = "Wpisz jedną wartość";
            }
            writer.println(info);
        } catch (NumberFormatException e) {
            writer.println("Niepoprawny typ danych");
        }
    }

    private String nonEmptyWeightParameterInfo(String nonEmptyParameterName, String value) {
        WeightValue weightValue;
        String info = null;

        switch (nonEmptyParameterName) {
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
