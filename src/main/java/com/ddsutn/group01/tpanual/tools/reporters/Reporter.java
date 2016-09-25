package com.ddsutn.group01.tpanual.tools.reporters;

import java.util.HashMap;

public class Reporter {

    public void updateReport(String key, Integer counter, HashMap<String, Integer> report) {
        if (report.containsKey(key)) {
            Integer resultsCounter = report.get(key);
            resultsCounter = resultsCounter + counter;
            report.put(key, resultsCounter);
        } else {
            report.put(key, counter);
        }
    }

}
