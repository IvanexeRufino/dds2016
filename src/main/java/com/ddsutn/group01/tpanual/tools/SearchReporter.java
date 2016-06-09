package com.ddsutn.group01.tpanual.tools;

import java.util.HashMap;

public class SearchReporter implements Reporter {

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