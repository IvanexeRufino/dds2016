package com.ddsutn.group01.tpanual.models.pois;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PoiMaster {
	private List<PointOfInterest> todosLosPoi;

    public PoiMaster() {
        todosLosPoi = new ArrayList<>();
    }

	public List<PointOfInterest> getTodosLosPoi() {
		return todosLosPoi;
	}

	public void agregarPoi(PointOfInterest unPoi) {
		todosLosPoi.add(unPoi);
	}

	public List<PointOfInterest> busquedaPoi(String unaPalabra){
		return todosLosPoi.stream().filter(poi -> poi.palabraEsta(unaPalabra)).collect(Collectors.toList());
	}
}
