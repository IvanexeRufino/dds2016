package com.ddsutn.group01.tpanual.models.pois;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import static org.mockito.Matchers.any;

public class SucursalBancoEstaCercaDeTest {
    private Point mockedPoint;
    private PointOfInterest poi;

    @Before
    public void init() {
        mockedPoint = Mockito.mock(Point.class);
        poi = new SucursalBanco("santander", mockedPoint);
    }

    @Test
    public void poiEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.49);
        Assert.assertTrue(poi.estaCercaDe(any(Point.class)));
    }

    @Test
    public void poiNoEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.5);
        Assert.assertFalse(poi.estaCercaDe(any(Point.class)));
    }
}
