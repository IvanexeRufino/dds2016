package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.origins.Origin;

import java.util.ArrayList;
import java.util.List;

public class PoiRepository {
    private static PoiRepository instance = null;
    private List<Origin> origins;
    private LocalOrigin localOrigin;
    private Buscador buscadorDePOI;

    public PoiRepository() {
        localOrigin = new LocalOrigin();
        origins = new ArrayList<>();
        buscadorDePOI = new Buscador();
    }
    
    public static PoiRepository getInstance() {
        if (instance == null) {
            instance = new PoiRepository();
        }

        return instance;
    }
    
    public Buscador getBuscador() {
        return buscadorDePOI;
    }
    
    public LocalOrigin getOrigenLocal() {
        return localOrigin;
    }

    public List<Origin> getOrigenes() {
        return origins;
    }
    
    public void addOrigin(Origin origin) {
        origins.add(origin);
    }

    public void add(PointOfInterest poi) {
        localOrigin.add(poi);
    }

    public void edit(PointOfInterest poi) {
        localOrigin.edit(poi);
    }

    public void remove(int indice) {
        localOrigin.remove(indice);
    }
    
}
