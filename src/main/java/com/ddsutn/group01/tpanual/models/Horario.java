package com.ddsutn.group01.tpanual.models;

import org.javatuples.Triplet;
import java.time.LocalTime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Horario {

	private List<Triplet<DayOfWeek,LocalTime,LocalTime>> horarios;

	public Horario() {
		horarios = new ArrayList<Triplet<DayOfWeek,LocalTime,LocalTime>>();
	}

	public void agregarHorario( DayOfWeek dia,LocalTime horarioDeEntrada,LocalTime horarioDeSalida) {

		Triplet<DayOfWeek, LocalTime, LocalTime> tripleta = Triplet.with(dia,horarioDeEntrada, horarioDeSalida);
		horarios.add(tripleta);
	}
	public Boolean estaDisponible(LocalDateTime ciertoMomento){
		LocalTime unInstante = LocalTime.of(ciertoMomento.getHour(),ciertoMomento.getMinute());
		return horarios.stream()	
                .anyMatch(horario -> horario.getValue0().equals(ciertoMomento.getDayOfWeek())
                && horario.getValue1().isBefore(unInstante)
                && horario.getValue2().isAfter(unInstante));
	}                    
	}

