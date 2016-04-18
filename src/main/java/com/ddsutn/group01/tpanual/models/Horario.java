package com.ddsutn.group01.tpanual.models;

import com.ddsutn.group01.tpanual.exceptions.HorarioInvalidoException;
import org.javatuples.Triplet;
import org.joda.time.LocalTime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Horario {

	private List<Triplet<DayOfWeek,LocalTime,LocalTime>> horarios;

	public Horario() {
		horarios = new ArrayList<Triplet<DayOfWeek,LocalTime,LocalTime>>();
	}

	public void agregarHorario( DayOfWeek dia, LocalTime inicio,  LocalTime fin) throws HorarioInvalidoException {

		Triplet<DayOfWeek, LocalTime, LocalTime> tripleta = Triplet.with(dia,inicio, fin);
		horarios.add(tripleta);
	}
	public Boolean estaDisponible(LocalDateTime ciertoMomento){
		LocalTime unInstante = LocalTime.now();
		return horarios.stream()	
                .anyMatch(horario -> horario.getValue0().equals(ciertoMomento.getDayOfWeek())
                && horario.getValue1().isBefore(unInstante)
                && horario.getValue2().isAfter(unInstante));
	}                    
	}

