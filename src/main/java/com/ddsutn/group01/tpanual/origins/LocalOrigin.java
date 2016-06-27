package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalOrigin implements Origin {
    private PoiDAO dao;

    public LocalOrigin() {
        this.dao = new PoiDAO();
    }

    public void add(PointOfInterest poi) {
        dao.create(poi);
    }

    public void edit(PointOfInterest poi) {
        dao.update(poi);
    }

    public void remove(PointOfInterest poi) {
        dao.delete(poi);
    }
    
    public PointOfInterest getPOI(int indice) {
        return dao.getPOI(indice);
    }

    public ArrayList<PointOfInterest> getAll() {
        return dao.findAll();
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        return dao.findAll().stream().filter(poi -> poi.palabraEsta(criteria)).collect(Collectors.toList());
    }
}
