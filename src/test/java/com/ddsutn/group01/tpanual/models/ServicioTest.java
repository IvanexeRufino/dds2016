package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioTest {
    private Servicio servicio;
    private DateTime unMomento;

    @Before
    public void init() {
        HorariosDeAtencion horariosDeAtencion = Mockito.mock(HorariosDeAtencion.class);
        servicio = new Servicio("foo", horariosDeAtencion);

        unMomento = DateTime.now();
        Mockito.when(horariosDeAtencion.estaDisponible(unMomento)).thenReturn(true);
    }

    @Test
    public void testEstaDisponible() {
        Assert.assertTrue(servicio.estaDisponible(unMomento));
    }

    @Test
    public void testNoEstaDisponible() {
        Assert.assertFalse(servicio.estaDisponible(unMomento.plusHours(1)));
    }
}
