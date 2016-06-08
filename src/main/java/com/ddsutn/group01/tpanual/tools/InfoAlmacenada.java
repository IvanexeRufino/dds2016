package com.ddsutn.group01.tpanual.tools;

public class InfoAlmacenada {
    private String criteria;
    private int cantidadDeResultados;
    private float tiempo;
    
    public InfoAlmacenada(String unaPalabra, int unaCantidad, long unTiempo) {
        criteria = unaPalabra;
        cantidadDeResultados = unaCantidad;
        tiempo = unTiempo;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getCantidadDeResultados() {
        return cantidadDeResultados;
    }

    public void setCantidadDeResultados(int cantidadDeResultados) {
        this.cantidadDeResultados = cantidadDeResultados;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

}
