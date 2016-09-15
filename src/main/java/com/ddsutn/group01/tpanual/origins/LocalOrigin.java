package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;
import java.util.stream.Collectors;

public class LocalOrigin implements Origin {
    private PoiDAO dao;

    // TODO: Deberíamos definir una interfaz DAO y recibirlo por param
    public LocalOrigin() {
        this.dao = new PoiDAO();
    }

    public void add(PointOfInterest poi) {
        dao.create(poi);
    }

    public void edit(PointOfInterest poi) {
        dao.update(poi);
    }

    public void remove(int indice) {
        dao.delete(indice);
    }

    public List<PointOfInterest> getAll() {
        return dao.findAll();
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        return dao.findAll().stream().filter(poi -> poi.palabraEsta(criteria)).collect(Collectors.toList());
    }
}
