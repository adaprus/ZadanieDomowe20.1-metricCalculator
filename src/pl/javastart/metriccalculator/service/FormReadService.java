package pl.javastart.metriccalculator.service;

import java.util.Map;
import java.util.Set;

public class FormReadService {
    public boolean checkIfOnlyOneParameterIsWritten(Map<String, String[]> map) {
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

    public String getNonEmptyParameterKey(Map<String, String[]> map) {
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
}
