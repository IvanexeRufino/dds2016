package com.ddsutn.group01.tpanual.models.pois;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;
import org.uqbar.geodds.Point;

import static org.mockito.Matchers.*;

public class ParadaColectivoTest {
    private Point mockedPoint;
    private PointOfInterest poi;

    @Before
    public void init() {
        mockedPoint = Mockito.mock(Point.class);
        poi = new ParadaColectivo("114", mockedPoint);
    }

    @Test
    public void ParadaColectivoEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.09);
        Assert.assertTrue(poi.estaCercaDe(any(Point.class)));
    }

    @Test
    public void ParadaColectivoNoEstaCercaDe() throws Exception {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.1);
        Assert.assertFalse(poi.estaCercaDe(any(Point.class)));
    }

}
