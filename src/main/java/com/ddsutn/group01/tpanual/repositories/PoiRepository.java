package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.Origin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoiRepository {
    private static PoiRepository instance = null;
    private List<Origin> origins;

    private PoiRepository() {
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

    public void add(PointOfInterest poi) {
        origins.stream().forEach((origen) -> origen.add(poi));
    }

    public void edit(PointOfInterest poi) {
        origins.stream().forEach((origen) -> origen.edit(poi));
    }

    public void remove(PointOfInterest poi) {
        origins.stream().forEach((origen) -> origen.remove(poi));
    }

    public List<PointOfInterest> find(String criteria) {
        return origins.stream().
            map(origin -> origin.find(criteria)).
            flatMap(List::stream).
            collect(Collectors.toList());
    }
}
