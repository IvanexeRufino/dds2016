package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.stream.Collectors;

class PoiDAO {
    private ArrayList<PointOfInterest> pois;

    PoiDAO() {
        this.pois = new ArrayList<PointOfInterest>();
    }

    void create(PointOfInterest poi) {
        pois.add(poi);
    }

    void update(PointOfInterest poi) {
        delete(poi);
        create(poi);
    }

    void delete(PointOfInterest poi) {
        pois.removeIf((poiLocal) -> poiLocal.getId().equals(poi.getId()));
    }

    PointOfInterest getPOI(int indice) {
        return pois.stream().filter(unPOI->unPOI.getId() == indice)
                            .collect(Collectors.toList())
                            .get(0);
    }
    
    ArrayList<PointOfInterest> findAll() {
        return pois;
    }
}
