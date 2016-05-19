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
    private PointOfInterest cgp;

    @Before
    public void init() {
        mockedPolygon = Mockito.mock(Polygon.class);
        cgp = new CentrosDeGestionYParticipacion(1, "foo", mockedPolygon);
    }

    @Test
    public void estaCercaDe() {
        Mockito.when(mockedPolygon.isInside(any(Point.class))).thenReturn(true);
        Assert.assertTrue(cgp.estaCercaDe(any(Point.class)));
    }

    @Test
    public void noEstaCercaDe() {
        Mockito.when(mockedPolygon.isInside(any(Point.class))).thenReturn(false);
        Assert.assertFalse(cgp.estaCercaDe(any(Point.class)));
    }
}
