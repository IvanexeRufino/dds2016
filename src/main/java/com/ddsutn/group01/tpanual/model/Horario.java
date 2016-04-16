package com.ddsutn.group01.tpanual.model;

import org.javatuples.*;
import org.joda.time.*;

import com.ddsutn.group01.tpanual.exceptions.*;

import java.util.ArrayList;
import java.util.List;


public class Horario {
	
	public enum Dia {
	    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
	}

	private List<Triplet<Dia,LocalTime,LocalTime>> horarios;

	public Horario() {
		this.horarios = new ArrayList<Triplet<Dia,LocalTime,LocalTime>>();
	}
	
	
	/**
	 * 
	 * Método para agregar un horario de atención. Por ej, 
	 * lunes de 12:20 a 20:00 se agregaría como:
	 * 		horario.agregarHorario(Horario.Dia.LUNES,new LocalTime(12,20), new LocalTime(20,00))
	 * 
	 * @param diaDeLaSemana Enum (LUNES, MARTES,MIERCOLES, ETC)
	 * @param inicio        Horario de inicio en formato LocalTime de Joda Time
	 * @param fin           Horario de cierre en formato LocalTime de Joda Time
	 * @throws HorarioInvalidoException 
	 */
	public void agregarHorario( Dia diaDeLaSemana, LocalTime inicio,  LocalTime fin) throws HorarioInvalidoException {
		if(fin.isBefore(inicio))
			throw new HorarioInvalidoException("La hora de fin no puede ser mayor a la hora de cierre!!!!");
	
		Triplet<Dia, LocalTime, LocalTime> tripleta = Triplet.with(diaDeLaSemana,inicio, fin);
		horarios.add(tripleta);
	}
	
	/**
	 * Se fija si en la coleccion de horarios en que esta disponible,
	 * se encuentra el momento que le estoy pasando por parametro.
	 * 
	 * @param ciertoMomento En formato DateTime de Joda, (new DateTime(2015, 03, 20, 15, 00))
	 * @return
	 * @throws HorarioInvalidoException
	 */
	public Boolean estaDisponible(DateTime ciertoMomento) throws HorarioInvalidoException {
		
		int dia = ciertoMomento.getDayOfWeek();
		Dia diaDeLaSemana;
		LocalTime horaDeCiertoMomento = new LocalTime(ciertoMomento);
		
		switch (dia) {
			case 1: diaDeLaSemana = Dia.LUNES;
				break;
			case 2: diaDeLaSemana = Dia.MARTES;
				break;
			case 3: diaDeLaSemana = Dia.MIERCOLES;
				break;
			case 4: diaDeLaSemana = Dia.JUEVES;
				break;
			case 5: diaDeLaSemana = Dia.VIERNES;
				break;
			case 6: diaDeLaSemana = Dia.SABADO;
				break;
			case 7: diaDeLaSemana = Dia.DOMINGO;
				break;
			default: throw new HorarioInvalidoException("Error con el horario");
		}
		
		return this.horarios.stream()
			.anyMatch(horario -> 
						horario.getValue0().equals(diaDeLaSemana)
					 && horario.getValue1().isBefore(horaDeCiertoMomento)
					 && horario.getValue2().isAfter(horaDeCiertoMomento));
		
						
	}
}