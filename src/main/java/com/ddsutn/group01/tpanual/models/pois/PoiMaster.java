package com.ddsutn.group01.tpanual.models.pois;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class PoiMaster {
	
	private List<PointOfInterest> todosLosPoi;
	
	  public PoiMaster() {
	        todosLosPoi = new ArrayList<>();
	    }

	public List<PointOfInterest> getTodosLosPoi() {
		return todosLosPoi;
	}
	
	public void agregarPoi (PointOfInterest unPoi) {
		todosLosPoi.add(unPoi);
	}
	
	public   Stream<PointOfInterest> busquedaPoi (String unaPalabra){
		
		Stream<PointOfInterest> poisQueCumplen = todosLosPoi.stream()
				.filter(poi -> poi.palabraEsta(unaPalabra));
		
		return poisQueCumplen;
		
		
	}
	
}
