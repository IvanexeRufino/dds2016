package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class Buscador {

    // TODO: El repo podría conocer al buscar. De esa forma todas las acciones (buscar, crear, eliminar, editar) se hacen directamente hablando con el repo
    public List<PointOfInterest> find(String searchText) {
        PoiRepository repositorio = PoiRepository.getInstance();
        List<PointOfInterest> lista = repositorio.getOrigenLocal().find(searchText);
        lista.addAll(repositorio.getOrigenes().stream()
            .map(origin -> origin.find(searchText))
            .flatMap(List::stream)
            .collect(Collectors.toList()));

        EntityManager em = PerThreadEntityManagers.getEntityManager();
        em.persist(new ResultadoBusqueda(searchText, lista));

        return lista;
    }

}
