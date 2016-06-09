package com.ddsutn.group01.tpanual.repositories.WithActions;

import java.util.HashMap;
import java.util.List;

import org.joda.time.LocalDate;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.reporters.Reporter;

public class RepositoryWithReport extends RepositoryWithActions{
    private Reporter reporter;
    private HashMap<String, Integer> data = new HashMap<>();

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
        String fecha = LocalDate.now().toString();
        reporter.updateReport(fecha,1,data);
    }

    public HashMap<String, Integer>  getReport() {
        return data;
    }
}
