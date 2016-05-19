package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrigenLocal implements OrigenDatos {
    private List<PointOfInterest> pois;

    public OrigenLocal() {
        this.pois = new ArrayList<>();
    }

    public List<PointOfInterest> getTodos() {
        return pois;
    }

    @Override
    public void agregar(PointOfInterest poi) {
        pois.add(poi);
    }

    @Override
    public void editar(PointOfInterest poi) {
        eliminar(poi);
        agregar(poi);
    }

    @Override
    public void eliminar(PointOfInterest poi) {
        pois.removeIf((poiLocal) -> poiLocal.getId().equals(poi.getId()));
    }

    @Override
    public List<PointOfInterest> buscar(String unaPalabra) {
        return pois.stream().filter((poi) -> poi.palabraEsta(unaPalabra)).collect(Collectors.toList());
    }
}
