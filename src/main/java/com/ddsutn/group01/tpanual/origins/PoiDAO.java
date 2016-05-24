package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;

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

    ArrayList<PointOfInterest> findAll() {
        return pois;
    }
}
