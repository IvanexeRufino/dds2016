package com.ddsutn.group01.tpanual.models.pois;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PoiMaster {
	private List<PointOfInterest> pois;

    public PoiMaster() {
        pois = new ArrayList<>();
    }

    public PoiMaster(ArrayList<PointOfInterest> pois) {
        this.pois = pois;
    }

	public void agregarPoi(PointOfInterest unPoi) {
		pois.add(unPoi);
	}

	public List<PointOfInterest> buscarPoi(String unaPalabra){
		return pois.stream().filter(poi -> poi.palabraEsta(unaPalabra)).collect(Collectors.toList());
	}
}
