package com.ddsutn.group01.tpanual.tools.reporters;

import java.util.HashMap;

public class Reporter {

    public void updateReport(String key, Integer value, HashMap<String, Integer> data) {
        if (data.containsKey(key)) {
            Integer resultsCounter = data.get(key);
            resultsCounter = resultsCounter + value;
            data.put(key, resultsCounter);
        } else {
            data.put(key, value);
        }
    }

}
