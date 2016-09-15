package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import java.util.List;
import java.util.stream.Collectors;

public class Buscador {
    
    public List<PointOfInterest> find(String criteria) {
        PoiRepository repositorio = PoiRepository.getInstance();
        List<PointOfInterest> lista = repositorio.getOrigenLocal().find(criteria);
        lista.addAll(repositorio.getOrigenes().stream()
                                              .map(origin -> origin.find(criteria))
                                              .flatMap(List::stream)
                                              .collect(Collectors.toList()));
        return lista;
    }
    
}