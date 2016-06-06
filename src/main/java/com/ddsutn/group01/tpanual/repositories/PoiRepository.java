package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.origins.Origin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoiRepository {
    private static PoiRepository instance = null;
    private List<Origin> origins;
    private LocalOrigin origenLocal;

    private PoiRepository() {
        origenLocal = new LocalOrigin();
        origins = new ArrayList<>();
    }

    public Origin getOrigenLocal(){
        return origins.get(0);
    }
    
    public static PoiRepository getInstance() {
        if (instance == null) {
            instance = new PoiRepository();
        }

        return instance;
    }

    public void addOrigin(Origin origin) {
        origins.add(origin);
    }

    public void add(PointOfInterest poi) {
        origenLocal.add(poi);
    }

    public void edit(PointOfInterest poi) {
        origenLocal.edit(poi);
    }

    public void remove(PointOfInterest poi) {
        origenLocal.remove(poi);
    }

    public List<PointOfInterest> find(String criteria) {
        List<PointOfInterest> lista = origenLocal.find(criteria);
        lista.addAll(origins.stream().
                     map(origin -> origin.find(criteria)).
                     flatMap(List::stream).
                     collect(Collectors.toList()));
        return lista;
    }
}
