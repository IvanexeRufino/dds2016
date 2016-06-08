package com.ddsutn.group01.tpanual.repositories.WithActions;

import java.util.List;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.Reporter;

public class RepositoryWithReport extends RepositoryWithActions{
    private Reporter reporter;

    RepositoryWithReport(Repository repository) {
        super(repository);
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        List<PointOfInterest> result = repository.find(criteria);

        updateReport();

        return result;
    }

    public void updateReport() {
        reporter.updateReport();
    }
}
