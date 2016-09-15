package com.ddsutn.group01.tpanual.Procesos.Log;

import org.joda.time.DateTime;

public class ProcessData {
    
    private int cantidad;
    private DateTime fecha;
    private String estado;
    
    public ProcessData(int cantidad, DateTime fecha, String estado) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
    }
}
