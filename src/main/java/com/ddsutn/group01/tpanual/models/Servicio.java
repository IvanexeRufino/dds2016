package com.ddsutn.group01.tpanual.models;

import java.time.LocalDateTime;

public class Servicio {
	private String nombre;
	private Horario horarioDeAtencion;
	public Servicio(String nombre, Horario unHorario)
	{
		this.nombre=nombre;
		this.horarioDeAtencion=unHorario;
	}
	public String getNombre()
	{
		return this.nombre;
	}
	public Boolean estaDisponible (LocalDateTime unHorario)
	{
		return horarioDeAtencion.estaDisponible(unHorario);
	}
}