package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import java.util.List;

class PoiDAO {
    private EntityManager entityManager;

    // TODO: definir una interfaz de db y recibirla por param
    PoiDAO() {
        this.entityManager = PerThreadEntityManagers.getEntityManager();
    }

    void create(PointOfInterest poi) {
        entityManager.persist(poi);
    }

    void update(PointOfInterest poi) {
        entityManager.merge(poi);
    }

    void delete(int indice) {
        entityManager.remove(entityManager.find(PointOfInterest.class, indice));
    }

    @SuppressWarnings("unchecked")
    List<PointOfInterest> findAll() {
        return (List<PointOfInterest>) entityManager.createQuery("from PointOfInterest").getResultList();
    }
}
