package com.ddsutn.group01.tpanual.tools;

import org.joda.time.LocalDate;

import java.util.HashMap;

public class SearchReporter implements Reporter {

    private HashMap<LocalDate, Integer> data = new HashMap<>();

    public void updateReport() {
        LocalDate date = LocalDate.now();
        if (data.containsKey(date)) {
            Integer resultsCounter = data.get(date);
            resultsCounter++;

            data.put(date, resultsCounter);
        } else {
            data.put(date, 1);
        }
    }

    public HashMap<LocalDate, Integer> getReport() {
        return data;
    }
}
