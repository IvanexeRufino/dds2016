package com.ddsutn.group01.tpanual.repositories.WithActions;

import java.util.List;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.Metrics;

public class RepositoryWithReporte extends RepositoryWithActions{
   
    private Metrics metrics;
    
    RepositoryWithReporte(Repository repository) {
        super(repository);
    }
    
    public void setMetricsSource(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        List<PointOfInterest> result = repository.find(criteria);
        actualizarReporte();
        return result;
    }
    
    public void actualizarReporte() {
        metrics.actualizarReporte();
    }
    
    public void obtenerReporte() {
        metrics.obtenerReporte();
    }
    
}
