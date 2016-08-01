package com.ddsutn.group01.tpanual.tools.metrics;

import com.ddsutn.group01.tpanual.repositories.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class Metrics implements Action {
    private long timer;
    private List<MetricsSource> metricsSource = new ArrayList<MetricsSource>();

    @Override
    public void precondition() {
        timer = System.nanoTime();
    }

    @Override
    public void postcondition(String criteria, int result, String nombre) {
        timer = System.nanoTime() - timer;
        almacenar(criteria, result, timer);
    }

    private void almacenar(String criteria, int resultsCount, long timeLapsed) {
        metricsSource.add(new MetricsSource(criteria, resultsCount, timeLapsed));
    }
}
