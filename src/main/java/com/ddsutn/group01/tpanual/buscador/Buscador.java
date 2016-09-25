package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import java.util.List;

public class Buscador {

    public List<PointOfInterest> find(String searchText) {
        PoisCache cache = PoisCache.getInstance();
        List<PointOfInterest> cachedResult = cache.get(searchText);

        List<PointOfInterest> result;

        if (cachedResult.isEmpty()) {
            result = PoiRepository.getInstance().findAll(searchText);
            cache.put(searchText, result);
        } else {
            result = cachedResult;
        }

        EntityManager em = PerThreadEntityManagers.getEntityManager();
        em.persist(new ResultadoBusqueda(searchText, result));

        return result;
    }

}
