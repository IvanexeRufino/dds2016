package com.ddsutn.group01.tpanual.repositories.actions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.tools.metrics.MetricsSource;

import java.util.List;

public class Metrics implements Action {
    private long timer;
    private MetricsSource metricsSource;

    @Override
    public void precondition() {
        timer = System.nanoTime();
    }

    @Override
    public void postcondition(String criteria, List<PointOfInterest> result) {
        timer = System.nanoTime() - timer;

        reportMetric(criteria, result.size(), timer);
    }

    public void setMetricsSource(MetricsSource metricsSource) {
        this.metricsSource = metricsSource;
    }

    public void reportMetric(String criteria, int resultsCount, long timeLapsed) {
        metricsSource.reportStat(criteria, resultsCount, timeLapsed);
    }
}
