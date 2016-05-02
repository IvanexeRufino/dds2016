package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import static org.mockito.Matchers.any;

public class ParadaColectivoTest {
    private Point mockedPoint;
    private String numeroColectivo;
    private PointOfInterest parada;

    @Before
    public void init() {
        mockedPoint = Mockito.mock(Point.class);
        numeroColectivo = "114";
        parada = new ParadaColectivo(numeroColectivo, mockedPoint);
    }

    @Test
    public void estaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.09);
        Assert.assertTrue(parada.estaCercaDe(any(Point.class)));
    }

    @Test
    public void noEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.1);
        Assert.assertFalse(parada.estaCercaDe(any(Point.class)));
    }

    @Test
    public void estaDisponible() {
        Assert.assertTrue(parada.estaDisponible(DateTime.now()));
    }

    @Test
    public void palabraEsta() {
        Assert.assertTrue(parada.palabraEsta(numeroColectivo));
    }

    @Test
    public void palabraNoEsta() {
        Assert.assertFalse(parada.palabraEsta("7"));
    }
}
