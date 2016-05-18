package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;

public class OrigenLocal implements OrigenDatos {
    
    ArrayList<PointOfInterest> repositorioDePOIs = new ArrayList<PointOfInterest>();
    
    public void crear(PointOfInterest poi) {
        repositorioDePOIs.add(poi);
    }

    public void editar(PointOfInterest poi) {
        // editar poi
    }

    public void eliminar(PointOfInterest poi) {
        repositorioDePOIs.remove(poi);
    }
    
    public ArrayList<PointOfInterest> buscar(String unaPalabra) {
        repositorioDePOIs.stream().filter(POI->POI.palabraEsta(unaPalabra));
        return repositorioDePOIs;
    }
}
