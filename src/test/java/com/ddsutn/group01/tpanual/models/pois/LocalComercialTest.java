package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Rubro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class LocalComercialTest {
    private Point point;

    @Before
    public void init() {
        point = new Point(-34.603689, -58.381652); // https://goo.gl/maps/NquccBrGJsz
    }

    @Test
    public void rubroKioskoEstaCercaDe() {
        Rubro kiosko = Rubro.kiosco;
        Point anotherPoint = new Point(-34.601921, -58.381701); // https://goo.gl/maps/P9bmo5D2P8r
        PointOfInterest poi = new LocalComercial("foo", point, kiosko);

        Assert.assertTrue(poi.estaCercaDe(anotherPoint));
    }

    @Test
    public void rubroLibreriasEscolaresEstaCercaDe() {
        Rubro libreriaEscolar = Rubro.libreriaEscolar;
        Point anotherPoint = new Point(-34.601400, -58.381726); // https://goo.gl/maps/ejnwoTqr7D62
        PointOfInterest poi = new LocalComercial("foo", point, libreriaEscolar);

        Assert.assertTrue(poi.estaCercaDe(anotherPoint));
    }

}
