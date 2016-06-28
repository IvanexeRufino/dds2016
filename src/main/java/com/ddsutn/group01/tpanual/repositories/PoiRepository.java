package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.origins.Origin;
import com.ddsutn.group01.tpanual.repositories.actions.Action;

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
    
    public void addAction(Action action) {
        buscadorDePOI.addAction(action);
    }

    public void removeAction(Action action) {
        buscadorDePOI.removeAction(action);
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

    public List<PointOfInterest> find(String criteria) {
        return buscadorDePOI.find(criteria);
    }
}
