package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;

public abstract class OrigenExterno implements OrigenDatos {
    
    @Override
    public void agregar(PointOfInterest poi) { }

    @Override
    public void editar(PointOfInterest poi) { }

    @Override
    public void eliminar(PointOfInterest poi) { }

    public abstract List<PointOfInterest> buscar(String unaPalabra);
}