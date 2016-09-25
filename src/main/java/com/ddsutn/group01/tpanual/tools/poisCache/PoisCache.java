package com.ddsutn.group01.tpanual.tools.poisCache;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoisCache {
    private static PoisCache instance;
    private HashMap<String, List<PointOfInterest>> busquedas;

    public PoisCache() {
        busquedas = new HashMap<>();
    }

    public static PoisCache getInstance() {
        if (instance == null) {
            instance = new PoisCache();
        }

        return instance;
    }

    public List<PointOfInterest> get(String searchText) {
        if (busquedas.containsKey(searchText)) {
            return busquedas.get(searchText);
        } else {
            return new ArrayList<>();
        }
    }

    public void put(String key, List<PointOfInterest> results) {
        busquedas.put(key, results);
    }
}
