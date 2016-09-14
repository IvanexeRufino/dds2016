package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class HorariosDeAtencion {
	//anotation para esto
    private List<Horario> horarios;

    public HorariosDeAtencion() {
        horarios = new ArrayList<>();
    }
    
    public List<Horario> getHorarios() {
        return horarios;
    }

    public void agregarHorario(Horario horario) {
        horarios.add(horario);
    }

    public Boolean estaDisponible(DateTime ciertoMomento) {
        return horarios.stream().anyMatch(horario -> horario.estaDisponible(ciertoMomento));
    }

    public void setHorarios(List<Horario> unosHorarios) {
        horarios = unosHorarios;       
    }
}
