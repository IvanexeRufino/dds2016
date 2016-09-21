package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.PersistentRecord;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class Buscador extends PersistentRecord {
	public Buscador() {}

    // TODO: El repo podría conocer al buscar. De esa forma todas las acciones (buscar, crear, eliminar, editar)
    // se hacen directamente hablando con el repo
    public List<PointOfInterest> find(String criteria) {
        PoiRepository repositorio = PoiRepository.getInstance();
        List<PointOfInterest> lista = repositorio.getOrigenLocal().find(criteria);
        lista.addAll(repositorio.getOrigenes().stream()
                                              .map(origin -> origin.find(criteria))
                                              .flatMap(List::stream)
                                              .collect(Collectors.toList()));
        EntityManager em = PerThreadEntityManagers.getEntityManager();
        em.persist(new Busqueda(criteria,lista));
        return lista;
    }
}
