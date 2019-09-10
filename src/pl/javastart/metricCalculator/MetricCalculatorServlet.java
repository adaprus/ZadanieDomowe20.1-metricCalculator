package pl.javastart.metricCalculator;

import service.CalculatorService;

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

        PrintWriter writer = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

            String metersString = request.getParameter("meters");
            double meters;
            double centimeters;
            double millimeters;
            Map<String, String[]> parameterMap = request.getParameterMap();
            String parameterName;
            String millimetersString = request.getParameter("millimeters");
            String centimetersString = request.getParameter("centimeters");
            CalculatorService service = new CalculatorService();
            String info = null;

            if (checkIfOnlyOneParameterIsWritten(parameterMap) == 1) {
                parameterName = checkParameterName(parameterMap);
                switch (parameterName) {
                    case "meters":
                        meters = Double.parseDouble(metersString);
                        info = service.metersRecountInfo(meters);
                        break;
                    case "centimeters":
                        centimeters = Double.parseDouble(centimetersString);
                        info = service.centimetersRecountInfo(centimeters);
                        break;
                    case "millimeters":
                        millimeters = Double.parseDouble(millimetersString);
                        info = service.millimetersRecountInfo(millimeters);
                        break;
                }
            } else {
                info = "Wpisz tylko jedną wartość";
            }
            writer.println(info);
    }

    private static String checkParameterName(Map<String, String[]> map) {
        String name = null;
        Set<String> set = map.keySet();

        for (String s : set) {
            if (!((map.get(s).equals(null)) || map.get(s).length == 0)) {
                name = s;
            }
        }
        return name;
    }

    private static int checkIfOnlyOneParameterIsWritten(Map<String, String[]> map) {
        int counter = 0;
        Set<String> set = map.keySet();

        for (String s : set) {
            if (!(map.get(s).equals(null) || map.get(s).length == 0)) {
                counter++;
            }
        }
        return counter;
    }
}
