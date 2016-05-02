package com.ddsutn.group01.tpanual.models;

import org.junit.Assert;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;

public class HorariosDeAtencionTest {
    private HorariosDeAtencion horariosDeAtencion;

    @Before
    public void init() {
        LocalTime horaDeApertura = new LocalTime(9, 0);
        LocalTime horaDeCierre = new LocalTime(18, 0);
        Horario horaAtencionJueves = new Horario(DayOfWeek.THURSDAY, horaDeApertura, horaDeCierre);
        Horario horaAtencionViernes = new Horario(DayOfWeek.FRIDAY, horaDeApertura, horaDeCierre);
        horariosDeAtencion = new HorariosDeAtencion();

        horariosDeAtencion.agregarHorario(horaAtencionJueves);
        horariosDeAtencion.agregarHorario(horaAtencionViernes);
    }

    @Test
    public void testEstaDisponible() {
        DateTime viernesPorLaTarde = new DateTime(2016, 4, 29, 17, 0);
        Assert.assertTrue(horariosDeAtencion.estaDisponible(viernesPorLaTarde));
    }

    @Test
    public void testNoEstaDisponibleUnDiaQueNoAtiende() {
        DateTime sabadoPorLaTarde = new DateTime(2016, 5, 29, 17, 0);
        Assert.assertFalse(horariosDeAtencion.estaDisponible(sabadoPorLaTarde));
    }

    @Test
    public void testNoEstaDisponibleUnHorarioQueNoAtiende() {
        DateTime viernesPorLaNoche = new DateTime(2016, 4, 29, 22, 0);
        Assert.assertFalse(horariosDeAtencion.estaDisponible(viernesPorLaNoche));
    }
}
