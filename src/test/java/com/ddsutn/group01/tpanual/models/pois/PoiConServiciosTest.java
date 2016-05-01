package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Servicio;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import static org.mockito.Matchers.any;

public class PoiConServiciosTest {
    private DateTime unHorario;
    private PoiConServicios poi;
    private Servicio mockedServicio;

    @Before
    public void init() {
        unHorario = DateTime.now();

        Point mockedPoint = Mockito.mock(Point.class);
        poi = Mockito.spy(new PoiConServicios("foo", mockedPoint) {});

        mockedServicio = Mockito.mock(Servicio.class);
        Mockito.when(mockedServicio.getNombre()).thenReturn("servicio foo");
        poi.agregarUnServicio(mockedServicio);
    }

    @Test
    public void testEstaDisponible() {
        Mockito.when(mockedServicio.estaDisponible(any(DateTime.class))).thenReturn(true);
        Assert.assertTrue(poi.estaDisponible(unHorario));
    }

    @Test
    public void testNoEstaDisponible() {
        Mockito.when(mockedServicio.estaDisponible(any(DateTime.class))).thenReturn(false);
        Assert.assertFalse(poi.estaDisponible(unHorario));
    }

    @Test
    public void testCumpleCondicion() {
        Assert.assertTrue(poi.palabraEsta("foo"));
    }

    @Test
    public void testNoCumpleCondicion() {
        Assert.assertFalse(poi.palabraEsta("bleh"));
    }
}
