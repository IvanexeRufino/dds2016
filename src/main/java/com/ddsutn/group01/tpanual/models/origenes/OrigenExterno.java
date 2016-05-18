package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;

public class OrigenExterno implements OrigenDatos {
    @Override
    public void crear(PointOfInterest poi) { }

    @Override
    public void editar(PointOfInterest poi) { }

    @Override
    public void eliminar(PointOfInterest poi) { }

    @Override
    public List<PointOfInterest> buscar(String unaPalabra) {
        // buscar poi
        return null;
    }
}
