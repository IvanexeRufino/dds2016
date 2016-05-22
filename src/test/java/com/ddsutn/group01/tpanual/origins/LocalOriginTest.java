package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

public class LocalOriginTest {

    private LocalOrigin localOrigin;
    private ParadaColectivo poi;

    @Before
    public void setUp() throws Exception {
        localOrigin = new LocalOrigin();
        Point mockedPoint = Mockito.mock(Point.class);
        poi = new ParadaColectivo(1, "7", mockedPoint);
    }

    @Test
    public void agregar() throws Exception {
        localOrigin.add(poi);
        Assert.assertFalse(localOrigin.getAll().isEmpty());
    }

    @Test
    public void editar() throws Exception {
        localOrigin.add(poi);
        Assert.assertFalse(localOrigin.getAll().get(0).palabraEsta("foo"));
        poi.agregarPalabraClave("foo");
        localOrigin.edit(poi);
        Assert.assertTrue(localOrigin.getAll().get(0).palabraEsta("foo"));
    }

    @Test
    public void eliminar() throws Exception {
        localOrigin.add(poi);
        localOrigin.remove(poi);
        Assert.assertTrue(localOrigin.getAll().isEmpty());
    }

    @Test
    public void buscar() throws Exception {
        localOrigin.add(poi);
        Assert.assertFalse(localOrigin.find(poi.getName()).isEmpty());
    }
}
