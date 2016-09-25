package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.db.PersistentRecord;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class ResultadoBusqueda extends PersistentRecord {

    @Column(length = 50)
    private String searchText;

    //no esta persistido POI
    @Transient
    private List<PointOfInterest> resultados;

    @SuppressWarnings("unused")
    private ResultadoBusqueda() {}

    public ResultadoBusqueda(String searchText, List<PointOfInterest> results) {
        this.searchText = searchText;
        this.resultados = results;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<PointOfInterest> getResultados() {
        return resultados;
    }

    public void setResultados(List<PointOfInterest> resultados) {
        this.resultados = resultados;
    }

}
