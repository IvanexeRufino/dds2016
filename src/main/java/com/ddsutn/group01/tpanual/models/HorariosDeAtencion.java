package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class HorariosDeAtencion {
    private List<Horario> horarios;

    public HorariosDeAtencion() {
        horarios = new ArrayList<>();
    }

    public void agregarHorario(DayOfWeek dia,LocalTime horaDeApertura,LocalTime horaDeCierre) {
        Horario horario = new Horario(dia, horaDeApertura, horaDeCierre);
        horarios.add(horario);
    }

    public Boolean estaDisponible(DateTime ciertoMomento){
        return horarios.stream()
                .anyMatch(horario -> horario.getDia().getValue() == ciertoMomento.getDayOfWeek()
                        && horario.getHoraDeApretura().isBefore(ciertoMomento.toLocalTime())
                        && horario.getHoraDeCierre().isAfter(ciertoMomento.toLocalTime()));
    }
}
