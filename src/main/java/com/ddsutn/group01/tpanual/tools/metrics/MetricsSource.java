package com.ddsutn.group01.tpanual.tools.metrics;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.ddsutn.group01.tpanual.PersistentRecord;

@Entity
public class MetricsSource extends PersistentRecord {
    
	@Column (length = 25)
    private String palabra;
    private int resultados;
    private long tiempo;
    
    public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
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

	public MetricsSource(String criteria, int resultsCount, long timeLapsed) {
        this.palabra = criteria;
        this.resultados = resultsCount;
        this.tiempo = timeLapsed;
    }
}
