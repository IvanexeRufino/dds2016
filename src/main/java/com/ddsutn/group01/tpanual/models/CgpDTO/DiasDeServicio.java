package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.time.DayOfWeek;
import org.joda.time.LocalTime;

import com.ddsutn.group01.tpanual.models.Horario;

public class DiasDeServicio {
	
	private int numeroDeDia;
	private int horaDesde;
	private int minutoDesde;
	private int horaHasta;
	private int minutoHasta;

	public Horario modelar(){
	   LocalTime horarioDeEntrada = new LocalTime(horaDesde, minutoDesde);
	   LocalTime horarioDeSalida = new LocalTime(horaHasta, minutoHasta);
	   Horario horario = new Horario(DayOfWeek.of(numeroDeDia), horarioDeEntrada, horarioDeSalida);
	   return horario;
	    }
}

