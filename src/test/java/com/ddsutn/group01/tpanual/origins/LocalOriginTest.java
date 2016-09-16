package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class LocalOriginTest {

    private LocalOrigin localOrigin;
    private ParadaColectivo poi;
    private EntityManager em = PerThreadEntityManagers.getEntityManager();
    private EntityTransaction tx = em.getTransaction();

    @Before
    public void setUp() throws Exception {
        localOrigin = new LocalOrigin();
        Point mockedPoint = Mockito.mock(Point.class);
        poi = new ParadaColectivo("7", mockedPoint);
    }

    @Test
    public void agregar() throws Exception {
    	tx.begin();
        localOrigin.add(poi);
        Assert.assertFalse(localOrigin.getAll().isEmpty());
        tx.rollback();
    }

    @Test
    public void editar() throws Exception {
    	tx.begin();
        localOrigin.add(poi);
        Assert.assertFalse(localOrigin.getAll().get(0).palabraEsta("foo"));
        poi.agregarPalabraClave("foo");
        localOrigin.edit(poi);
        Assert.assertTrue(localOrigin.getAll().get(0).palabraEsta("foo"));
        tx.rollback();
    }

    @Test
    public void eliminar() throws Exception {
    	tx.begin();
        localOrigin.add(poi);
        localOrigin.remove(poi.getId());
        Assert.assertTrue(localOrigin.getAll().isEmpty());
        tx.rollback();
    }

    @Test
    public void buscar() throws Exception {
    	tx.begin();
        localOrigin.add(poi);
        Assert.assertFalse(localOrigin.find(poi.getName()).isEmpty());
        tx.rollback();
    }
}
