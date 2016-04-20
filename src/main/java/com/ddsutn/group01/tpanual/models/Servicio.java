package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;

public class Servicio {
	private String nombre;
	private HorariosDeAtencion horarioDeAtencion;

	public Servicio(String nombre, HorariosDeAtencion horarioDeAtencion) {
		this.nombre = nombre;
		this.horarioDeAtencion = horarioDeAtencion;
	}

	public String getNombre() {
        return this.nombre;
	}

	public Boolean estaDisponible(DateTime unHorario) {
        return horarioDeAtencion.estaDisponible(unHorario);
	}
}
