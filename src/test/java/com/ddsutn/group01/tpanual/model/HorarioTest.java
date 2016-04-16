package com.ddsutn.group01.tpanual.model;

import com.ddsutn.group01.tpanual.exceptions.*;
import com.ddsutn.group01.tpanual.model.Horario.Dia;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.joda.time.*;

public class HorarioTest {
    private Horario horario;

    @Before
    public void init() throws HorarioInvalidoException {
        horario = new Horario();
        horario.agregarHorario(Dia.LUNES, new LocalTime(8,00), new LocalTime(20,00));
        horario.agregarHorario(Dia.MARTES, new LocalTime(10,00), new LocalTime(20,00));
        horario.agregarHorario(Dia.MIERCOLES, new LocalTime(12,00), new LocalTime(20,00));
    }

    @Test
    public void estaCerrado() throws HorarioInvalidoException {
    	Assert.assertFalse(horario.estaDisponible(DateTime.now()));
    }

    @Test
    public void estaAbierto() throws HorarioInvalidoException {
    	Assert.assertTrue(horario.estaDisponible(new DateTime(2016, 4, 11, 10, 00)));
    }

    @Test
    public void estaCerrado2() throws HorarioInvalidoException {
    	Assert.assertFalse(horario.estaDisponible(new DateTime(2016, 4, 11, 23, 00)));
    }
}
