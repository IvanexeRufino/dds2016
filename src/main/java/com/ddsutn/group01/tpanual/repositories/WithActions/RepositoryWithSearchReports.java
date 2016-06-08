package com.ddsutn.group01.tpanual.repositories.WithActions;

import java.util.List;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.Reporter;

public class RepositoryWithSearchReports extends RepositoryWithActions{
    
    private Reporter reporter;
   
    RepositoryWithSearchReports(Repository repository) {
        super(repository);
    }
    
    public void setreporter(Reporter metrics) {
        this.reporter = metrics;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        List<PointOfInterest> result = repository.find(criteria);
        actualizarReporte();
        return result;
    }
    
    public void actualizarReporte() {
        reporter.actualizarReporte();
    }
    
    public void obtenerReporte() {
        reporter.obtenerReporte();
    }
    
}
