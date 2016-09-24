package com.ddsutn.group01.tpanual.procesos.Log;

import org.joda.time.DateTime;

public class ProcessData {

    private int cantidad;
    private DateTime fecha;
    private String estado;

    public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public DateTime getFecha() {
		return fecha;
	}

	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ProcessData(int cantidad, DateTime fecha, String estado) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
    }
}
