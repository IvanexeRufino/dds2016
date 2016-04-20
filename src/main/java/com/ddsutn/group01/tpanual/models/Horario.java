package com.ddsutn.group01.tpanual.models;

import org.joda.time.LocalTime;
import java.time.DayOfWeek;


public class Horario {
    private DayOfWeek dia;
    private LocalTime horaDeApretura;
    private LocalTime horaDeCierre;

    public Horario(DayOfWeek dia, LocalTime horaDeApretura, LocalTime horaDeCierre) {
        this.dia = dia;
        this.horaDeApretura = horaDeApretura;
        this.horaDeCierre = horaDeCierre;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public LocalTime getHoraDeApretura() {
        return horaDeApretura;
    }

    public LocalTime getHoraDeCierre() {
        return horaDeCierre;
    }
}

