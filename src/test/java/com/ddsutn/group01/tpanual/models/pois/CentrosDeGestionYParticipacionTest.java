package com.ddsutn.group01.tpanual.models.pois;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import static org.mockito.Matchers.any;

public class CentrosDeGestionYParticipacionTest {
    private Polygon mockedPolygon;
    private PointOfInterest poi;

    @Before
    public void init() {
        mockedPolygon = Mockito.mock(Polygon.class);
        poi = new CentrosDeGestionYParticipacion("foo", mockedPolygon);
    }

    @Test
    public void CgpEstaCercaDe() {
        Mockito.when(mockedPolygon.isInside(any(Point.class))).thenReturn(true);
        Assert.assertTrue(poi.estaCercaDe(any(Point.class)));
    }

    @Test
    public void CgpNoEstaCercaDe() {
        Mockito.when(mockedPolygon.isInside(any(Point.class))).thenReturn(false);
        Assert.assertFalse(poi.estaCercaDe(any(Point.class)));
    }
}
