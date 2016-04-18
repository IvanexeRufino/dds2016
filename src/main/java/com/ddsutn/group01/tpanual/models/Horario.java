package com.ddsutn.group01.tpanual.models;

import com.ddsutn.group01.tpanual.exceptions.HorarioInvalidoException;
import org.javatuples.Triplet;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Horario {

	private List<Triplet<DayOfWeek,LocalTime,LocalTime>> horarios;

	public Horario() {
		horarios = new ArrayList<Triplet<DayOfWeek,LocalTime,LocalTime>>();
	}
	

	/**
	 * Método para agregar un horario de atención. Por ej,
	 * lunes de 12:20 a 20:00 se agregaría como:
	 * 		horario.agregarHorario(Horario.Dia.LUNES,new LocalTime(12,20), new LocalTime(20,00))
	 *
	 * @param diaDeLaSemana Enum (LUNES, MARTES,MIERCOLES, ETC)
	 * @param inicio        Horario de inicio en formato LocalTime de Joda Time
	 * @param fin           Horario de cierre en formato LocalTime de Joda Time
	 * @throws HorarioInvalidoException
	 */
	public void agregarHorario( DayOfWeek dia, LocalTime inicio,  LocalTime fin) throws HorarioInvalidoException {
		if(fin.isBefore(inicio))
			throw new HorarioInvalidoException("La hora de fin no puede ser mayor a la hora de cierre!!!!");

		Triplet<DayOfWeek, LocalTime, LocalTime> tripleta = Triplet.with(dia,inicio, fin);
		horarios.add(tripleta);
	}

	/**
	 * Se fija si en la coleccion de horarios en que esta disponible,
	 * se encuentra el momento que le estoy pasando por parametro.
	 *
	 * @param c
	 * iertoMomento En formato DateTime de Joda, (new DateTime(2015, 03, 20, 15, 00))
	 * @return
	 * @throws HorarioInvalidoException
	 */
	public Boolean estaDisponible(LocalDateTime ciertoMomento) throws HorarioInvalidoException {
		return horarios.stream()	
                .anyMatch(horario -> horario.getValue0().equals(diaDeLaSemana)
                && (0 < ciertoMomento.getMinute() < 59);
	}
                
                
                
	}

