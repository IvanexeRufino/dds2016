package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.PersistentRecord;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class ResultadoBusqueda extends PersistentRecord {

    @Column(length = 50)
    private String criteria;

    //no esta persistido POI
    @Transient
    private List<PointOfInterest> resultados;

    @SuppressWarnings("unused")
    private ResultadoBusqueda() {
    }

    public ResultadoBusqueda(String parametros, List<PointOfInterest> results) {
        this.criteria = parametros;
        this.resultados = results;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<PointOfInterest> getResultados() {
        return resultados;
    }

    public void setResultados(List<PointOfInterest> resultados) {
        this.resultados = resultados;
    }

}
