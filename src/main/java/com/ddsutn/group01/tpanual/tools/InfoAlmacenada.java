package com.ddsutn.group01.tpanual.tools;

import org.joda.time.LocalDate;

public class InfoAlmacenada {
    private String criteria;
    private int cantidadDeResultados;
    private float tiempo;
    private LocalDate fecha;
    
    public InfoAlmacenada(String unaPalabra, int unaCantidad, long unTiempo, LocalDate unaFecha) {
        criteria = unaPalabra;
        cantidadDeResultados = unaCantidad;
        tiempo = unTiempo;
        fecha = unaFecha;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
