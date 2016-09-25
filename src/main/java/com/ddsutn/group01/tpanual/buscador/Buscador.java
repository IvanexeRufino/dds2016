package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import java.util.List;

public class Buscador {

    // TODO: El repo podría conocer al buscar. De esa forma todas las acciones (buscar, crear, eliminar, editar) se hacen directamente hablando con el repo
    public List<PointOfInterest> find(String searchText) {
        List<PointOfInterest> result = PoiRepository.getInstance().findAll(searchText);

        EntityManager em = PerThreadEntityManagers.getEntityManager();
        em.persist(new ResultadoBusqueda(searchText, result));

        return result;
    }

}
