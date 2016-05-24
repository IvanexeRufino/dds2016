package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class HorariosDeAtencion {
    private List<Horario> horarios;

    public HorariosDeAtencion() {
        horarios = new ArrayList<>();
    }

    public void agregarHorario(Horario horario) {
        horarios.add(horario);
    }
    
    public void setHorarios(List<Horario> unosHorarios) {
        this.horarios = unosHorarios;
    }

    public Boolean estaDisponible(DateTime ciertoMomento) {
        return horarios.stream().anyMatch(horario -> horario.estaDisponible(ciertoMomento));
    }
}
