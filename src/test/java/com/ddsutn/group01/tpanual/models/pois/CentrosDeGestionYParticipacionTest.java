package com.ddsutn.group01.tpanual.models.pois;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class CentrosDeGestionYParticipacionTest {

    private PointOfInterest poi;

    @Before
    public void init() {
        Polygon polygon = new Polygon();
        polygon.add(new Point(-34.603689, -58.381652)); // https://goo.gl/maps/NquccBrGJsz
        polygon.add(new Point(-34.601400, -58.381726)); // https://goo.gl/maps/ejnwoTqr7D62
        polygon.add(new Point(-34.602442, -58.379577)); // https://goo.gl/maps/Dp5be3CztPJ2

        poi = new CentrosDeGestionYParticipacion("foo", polygon);
    }

    @Test
    public void testEstaCercaDe() {
        Point anotherPoint = new Point(-34.602424, -58.380961); // https://goo.gl/maps/YvnTJCYM3aS2
        Assert.assertTrue(poi.estaCercaDe(anotherPoint));
    }
}
