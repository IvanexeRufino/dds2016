package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;

import java.util.List;
import java.util.concurrent.Callable;

public class RepositoryMetrics extends RepositoryWithActions {
//    private Reporter reporter;

    public RepositoryMetrics(Repository repository) {
        super(repository);
//      metrics = new Reporter;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        long startTime = System.nanoTime();
        List<PointOfInterest> result = repository.find(criteria);
        long estimatedTime = System.nanoTime() - startTime;

//        Metrics.report_stat(criteria, result.size(), estimatedTime);

        return result;
    }
}
