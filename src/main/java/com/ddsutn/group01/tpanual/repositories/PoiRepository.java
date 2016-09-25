package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.origins.Origin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PoiRepository {

    private static PoiRepository instance = null;
    private List<Origin> origins;
    private LocalOrigin localOrigin;

    public PoiRepository() {
        localOrigin = new LocalOrigin();
        origins = new ArrayList<>();
    }

    public static PoiRepository getInstance() {
        if (instance == null) {
            instance = new PoiRepository();
        }

        return instance;
    }

    public void addExternalOrigin(Origin origin) {
        origins.add(origin);
    }

    public void add(PointOfInterest poi) {
        localOrigin.add(poi);
    }

    public void edit(PointOfInterest poi) {
        localOrigin.edit(poi);
    }

    public void remove(int indice) {
        localOrigin.remove(indice);
    }

    public List<PointOfInterest> getAllLocal() {
        return localOrigin.getAll();
    }

    public List<PointOfInterest> findLocally(String searchText) {
        return localOrigin.find(searchText);
    }

    public List<PointOfInterest> findAll(String searchText) {
        List<PointOfInterest> localResults = findLocally(searchText);
        List<PointOfInterest> externalResults = origins.stream()
            .map(origin -> origin.find(searchText))
            .flatMap(List::stream)
            .collect(Collectors.toList());

        List<PointOfInterest> allResults = new ArrayList<>();
        Stream.of(localResults, externalResults).forEach(allResults::addAll);

        return allResults;
    }

}
