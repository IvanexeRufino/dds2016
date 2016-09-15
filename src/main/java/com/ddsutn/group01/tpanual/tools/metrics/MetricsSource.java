package com.ddsutn.group01.tpanual.tools.metrics;

public class MetricsSource {
    
    private String palabra;
    private int resultados;
    private long tiempo;
    
    public MetricsSource(String criteria, int resultsCount, long timeLapsed) {
        this.palabra = criteria;
        this.resultados = resultsCount;
        this.tiempo = timeLapsed;
    }
}
