package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import org.uqbar.geodds.Point;

public class PointOfInterestTest {
    private PointOfInterest poi;

    @Before
    public void init() {
        Point point = new Point(-34.603689, -58.381652); // https://goo.gl/maps/NquccBrGJsz
        poi = Mockito.spy(new PointOfInterest("foo", point) {
            public Boolean estaDisponible(DateTime unHorario) { return null; }
        });
    }

    @Test
    public void testEstaCercaDe() {
        Point anotherPoint = new Point(-34.601400, -58.381726); // https://goo.gl/maps/ejnwoTqr7D62
        Assert.assertTrue(poi.estaCercaDe(anotherPoint));
    }
}
