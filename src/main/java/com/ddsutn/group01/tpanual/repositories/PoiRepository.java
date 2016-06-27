package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.origins.Origin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoiRepository implements Repository {
    private static PoiRepository instance = null;
    private List<Origin> origins;
    private LocalOrigin localOrigin;

    private PoiRepository() {
        localOrigin = new LocalOrigin();
        origins = new ArrayList<>();
    }

    public static PoiRepository getInstance() {
        if (instance == null) {
            instance = new PoiRepository();
        }

        return instance;
    }

    public void addOrigin(Origin origin) {
        origins.add(origin);
    }

    @Override
    public void add(PointOfInterest poi) {
        localOrigin.add(poi);
    }

    @Override
    public void edit(PointOfInterest poi) {
        localOrigin.edit(poi);
    }

    @Override
    public void remove(PointOfInterest poi) {
        localOrigin.remove(poi);
    }

    public PointOfInterest getPOI(int indice) {
        return localOrigin.getPOI(indice);
    }
    
    @Override
    public List<PointOfInterest> find(String criteria) {
        List<PointOfInterest> lista = localOrigin.find(criteria);

        lista.addAll(origins.stream()
            .map(origin -> origin.find(criteria))
            .flatMap(List::stream)
            .collect(Collectors.toList()));

        return lista;
    }
}
