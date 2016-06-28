package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.actions.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buscador {
    private ArrayList<Action> actions = new ArrayList<>();

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    public List<PointOfInterest> find(String criteria) {
        PoiRepository repositorio = PoiRepository.getInstance();
        actions.forEach(Action::precondition);
        List<PointOfInterest> lista = repositorio.getOrigenLocal().find(criteria);
        lista.addAll(repositorio.getOrigenes().stream()
                                              .map(origin -> origin.find(criteria))
                                              .flatMap(List::stream)
                                              .collect(Collectors.toList()));
        actions.forEach(action -> action.postcondition(criteria, lista));

        return lista;
    }
}