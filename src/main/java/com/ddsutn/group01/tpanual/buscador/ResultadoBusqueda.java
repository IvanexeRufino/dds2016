package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.db.PersistentRecord;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

@Entity
public class ResultadoBusqueda extends PersistentRecord {

    @Id
    private String searchText;

    private List<PointOfInterest> resultados;

    @SuppressWarnings("unused")
    private ResultadoBusqueda() {
    }

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
