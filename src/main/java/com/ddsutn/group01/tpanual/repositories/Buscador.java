package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Buscador {
	@Id @GeneratedValue
	private long id;
	
	private Buscador(){}
    
    public List<PointOfInterest> find(String criteria) {
        PoiRepository repositorio = PoiRepository.getInstance();
        List<PointOfInterest> lista = repositorio.getOrigenLocal().find(criteria);
        lista.addAll(repositorio.getOrigenes().stream()
                                              .map(origin -> origin.find(criteria))
                                              .flatMap(List::stream)
                                              .collect(Collectors.toList()));
//		  persistir las busquedas con sus parametros
//        EntityManager em = Persistence.createEntityManagerFactory("db").createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.persist(new Busqueda(criteria,lista));
//        tx.commit();
        return lista;
    }
    
}