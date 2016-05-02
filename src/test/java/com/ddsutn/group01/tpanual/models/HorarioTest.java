package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;

public class HorarioTest {
    private Horario horario;
    private DateTime unMomento;

    @Before
    public void init() {
        LocalTime horaDeApertura = new LocalTime(9, 0);
        LocalTime horaDeCierre = new LocalTime(18, 0);
        horario = new Horario(DayOfWeek.FRIDAY, horaDeApertura, horaDeCierre);

        unMomento = new DateTime(2016, 4, 29, 17, 0);
    }

    @Test
    public void EstaDisponible() {
        Assert.assertTrue(horario.estaDisponible(unMomento));
    }

    @Test
    public void noEstaDisponibleSiNoEsElMismoDia() {
        Assert.assertFalse(horario.estaDisponible(unMomento.plusDays(1)));
    }

    @Test
    public void noEstaDisponibleSiEsMismoDiaPeroNoDentroDelHoraio() {
        Assert.assertFalse(horario.estaDisponible(unMomento.plusHours(1)));
    }
}
