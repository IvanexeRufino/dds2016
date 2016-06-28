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
        delete(poi.getId());
        create(poi);
    }

    void delete(int indice) {
        pois.removeIf((poiLocal) -> poiLocal.getId().equals(indice));
    }
    
    ArrayList<PointOfInterest> findAll() {
        return pois;
    }
}
