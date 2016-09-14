package com.ddsutn.group01.tpanual;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersistentRecordTest {
    private EntityManager entityManager;

    @Before
    public void setUp() {
        entityManager = PerThreadEntityManagers.getEntityManager();
    }

    @Test
    public void xxx() {
        ParadaColectivo object = new ParadaColectivo("foo", new Point(1, 2));
        EntityTransaction tx = entityManager.getTransaction();

        tx.begin();
        entityManager.persist(object);
        tx.commit();

        PersistentRecord persistedObject = entityManager.find(ParadaColectivo.class, 1);

        Assert.assertEquals(persistedObject.getId(), (Integer)1);
    }
}
