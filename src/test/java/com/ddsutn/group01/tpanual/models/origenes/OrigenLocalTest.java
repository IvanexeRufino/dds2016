package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

public class OrigenLocalTest {

    private OrigenLocal origenLocal;
    private ParadaColectivo poi;

    @Before
    public void setUp() throws Exception {
        origenLocal = new OrigenLocal();
        Point mockedPoint = Mockito.mock(Point.class);
        poi = new ParadaColectivo(1, "7", mockedPoint);
    }

    @Test
    public void agregar() throws Exception {
        origenLocal.agregar(poi);
        Assert.assertFalse(origenLocal.getTodos().isEmpty());
    }

    @Test
    public void editar() throws Exception {
        origenLocal.agregar(poi);
        Assert.assertFalse(origenLocal.getTodos().get(0).palabraEsta("foo"));
        poi.agregarPalabraClave("foo");
        origenLocal.editar(poi);
        Assert.assertTrue(origenLocal.getTodos().get(0).palabraEsta("foo"));
    }

    @Test
    public void eliminar() throws Exception {
        origenLocal.agregar(poi);
        origenLocal.eliminar(poi);
        Assert.assertTrue(origenLocal.getTodos().isEmpty());
    }

    @Test
    public void buscar() throws Exception {
        origenLocal.agregar(poi);
        Assert.assertFalse(origenLocal.buscar(poi.getName()).isEmpty());
    }
}
