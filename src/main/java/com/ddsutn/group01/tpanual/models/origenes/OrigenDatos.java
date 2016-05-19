package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;

public interface OrigenDatos {
    void agregar(PointOfInterest poi);

    void editar(PointOfInterest poi);

    void eliminar(PointOfInterest poi);

    List<PointOfInterest> buscar(String unaPalabra);
}
