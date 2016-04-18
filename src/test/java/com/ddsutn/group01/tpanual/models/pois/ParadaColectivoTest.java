package com.ddsutn.group01.tpanual.models.pois;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.uqbar.geodds.Point;

public class ParadaColectivoTest {
    private PointOfInterest poi;

    @Before
    public void init() {
        Point point = new Point(-34.603689, -58.381652); // https://goo.gl/maps/NquccBrGJsz
        poi = new ParadaColectivo("114", point);
    }

    @Test
    public void testEstaCercaDe() {
        Point anotherPoint = new Point(-34.602795, -58.381586); // https://goo.gl/maps/oq8Wz2qUGq52
        Assert.assertTrue(poi.estaCercaDe(anotherPoint));
    }
}
