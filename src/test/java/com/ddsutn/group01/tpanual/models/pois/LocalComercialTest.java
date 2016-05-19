package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import static org.mockito.Matchers.*;

public class LocalComercialTest {
    private LocalComercial localComercial;
    private Point mockedPoint;
    private HorariosDeAtencion horariosDeAtencion;
    private Rubro rubro;

    @Before
    public void init() {
        mockedPoint =  Mockito.mock(Point.class);
        horariosDeAtencion = Mockito.mock(HorariosDeAtencion.class);
        rubro = Rubro.kiosco;

        localComercial = new LocalComercial(1, "unLocal", mockedPoint, rubro, horariosDeAtencion);
    }

    @Test
    public void estaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(rubro.getRadioDeCercania() - 0.1);
        Assert.assertTrue("si esta cerca del radio de cercania del rubro",
                localComercial.estaCercaDe(any(Point.class)));
    }

    @Test
    public void noEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(rubro.getRadioDeCercania());
        Assert.assertFalse("si esta fuera del radio de cercania del rubro",
                localComercial.estaCercaDe(any(Point.class)));
    }

    @Test
    public void estaDisponible() {
        Mockito.when(horariosDeAtencion.estaDisponible(any(DateTime.class))).thenReturn(true);
        Assert.assertTrue("si su horario de atención está disponible",
                localComercial.estaDisponible(any(DateTime.class)));
    }

    @Test
    public void noEstaDisponible() {
        Mockito.when(horariosDeAtencion.estaDisponible(any(DateTime.class))).thenReturn(false);
        Assert.assertFalse("si su horario de atención no está disponible",
                localComercial.estaDisponible(any(DateTime.class)));
    }

    @Test
    public void palabraEsta() {
        Assert.assertTrue(localComercial.palabraEsta(rubro.getNombre()));
    }

    @Test
    public void palabraNoEsta() {
        Assert.assertFalse(localComercial.palabraEsta("otroNombre"));
    }
}
