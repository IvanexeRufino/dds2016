package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;

import java.util.List;

public class RepositoryWithMetrics extends RepositoryWithActions {
//    private Metrics metrics;

    public RepositoryWithMetrics(Repository repository) {
        super(repository);
    }

//    public void setMetricsSource(Metrics metrics) {
//        this.metrics = metrics;
//    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        long startTime = System.nanoTime();
        List<PointOfInterest> result = repository.find(criteria);
        long estimatedTime = System.nanoTime() - startTime;

        report_metric(criteria, result.size(), estimatedTime);

        return result;
    }

    public void report_metric(String criteria, int resultsCount, long timeLapsed) {
//        metrics.report_stat(criteria, result.size(), estimatedTime);
    }
}
