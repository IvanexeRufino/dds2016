package com.ddsutn.group01.tpanual.tools.metrics;

import com.ddsutn.group01.tpanual.db.PersistentRecord;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Metrics extends PersistentRecord {

    @Column(length = 25)
    private String searchText;

    private int resultados;

    private long tiempo;

    public Metrics(String searchText, int resultsCount, long timeLapsed) {
        this.searchText = searchText;
        this.resultados = resultsCount;
        this.tiempo = timeLapsed;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public int getResultados() {
        return resultados;
    }

    public void setResultados(int resultados) {
        this.resultados = resultados;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
}
