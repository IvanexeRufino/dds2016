package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.time.DayOfWeek;

import javax.persistence.Entity;

@Entity
public class Horario {
    private DayOfWeek dia;
    private LocalTime horaDeApertura;
    private LocalTime horaDeCierre;

    public Horario(DayOfWeek dia, LocalTime horaDeApertura, LocalTime horaDeCierre) {
        this.dia = dia;
        this.horaDeApertura = horaDeApertura;
        this.horaDeCierre = horaDeCierre;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public LocalTime getHoraDeApertura() {
        return horaDeApertura;
    }

    public LocalTime getHoraDeCierre() {
        return horaDeCierre;
    }

    public Boolean estaDisponible(DateTime ciertoMomento) {
        return this.mismoDia(ciertoMomento.getDayOfWeek())
            && this.estaEntreHorarios(ciertoMomento.toLocalTime());
    }

    private Boolean mismoDia(int unDia) {
        return dia.getValue() == unDia;
    }

    private Boolean estaEntreHorarios(LocalTime ciertoMomento) {
        return horaDeApertura.isBefore(ciertoMomento) && horaDeCierre.isAfter(ciertoMomento);
    }
}

