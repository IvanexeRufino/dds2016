package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import static org.mockito.Matchers.any;

public class PointOfInterestTest {
    private Point mockedPoint;
    private PointOfInterest poi;
    private String palabraClave;

    @Before
    public void init() {
        mockedPoint = Mockito.mock(Point.class);
        poi = Mockito.spy(new PointOfInterest(1, "foo", mockedPoint) {
            @Override
            public Boolean estaDisponible(DateTime unHorario) {
                return false;
            }

            @Override
            protected Boolean cumpleCondicion(String unaPalabra) {
                return false;
            }
        });

        palabraClave = "foo";
        poi.agregarPalabraClave(palabraClave);
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

    @Test
    public void palabraEsta() {
        Assert.assertTrue(poi.palabraEsta(palabraClave));
    }

    @Test
    public void palabraNoEsta() {
        poi.agregarPalabraClave("foo");
        Assert.assertFalse(poi.palabraEsta("otraPalabraClave"));
    }
}
