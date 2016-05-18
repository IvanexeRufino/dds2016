package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;

public interface OrigenDatos {
    
    List<PointOfInterest> buscar(String unaPalabra);
}
