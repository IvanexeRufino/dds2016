package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

class PoiDAO {
    private EntityManager entityManager;

    PoiDAO() {
        this.entityManager = PerThreadEntityManagers.getEntityManager();
    }

    void create(PointOfInterest poi) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(poi);
        tx.commit();
    }

    void update(PointOfInterest poi) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(poi);
        tx.commit();
    }

    void delete(int indice) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entityManager.find(PointOfInterest.class, indice));
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    List<PointOfInterest> findAll() {
        return (List<PointOfInterest>) entityManager.createQuery("from PointOfInterest").getResultList();
    }
}
