package com.ddsutn.group01.tpanual.models.pois;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoiDAO {
	/* 
	 * PoiDAO es un singleton que  hace de repositorio de POIs
	 * Aisla la lógica de persistencia / obtención de POIs
	 */
	
    private static PoiDAO instancia = new PoiDAO();
    private List<PointOfInterest> poisLocales;
    private List<OrigenDatos> origenes;
    
    
	private PoiDAO() {
		poisLocales = new ArrayList<>();
	}
	
    public static PoiDAO getInstance() {
        return instancia;
    }
    
    public void alta(PointOfInterest poi) {
    	poisLocales.add(poi);
    }
    
    public void baja(PointOfInterest poi) {
    	poisLocales.remove(poi);
    }
    
    public void modificacion(PointOfInterest poi){
    	poisLocales.remove(poi);
    	poisLocales.add(poi);
    }
    
    public List<PointOfInterest> buscarPoi(String unaPalabra){
    	ArrayList<PointOfInterest> poisFiltrados = new ArrayList<PointOfInterest>();
    	
    	// Locales al sistema
    	poisFiltrados.addAll(poisLocales.stream().filter(poi -> poi.palabraEsta(unaPalabra)).collect(Collectors.toList()));
    	
    	// Heterogeneos
    	origenes.stream().forEach(origen -> poisFiltrados.addAll(origen.filtrarPorCriterio(unaPalabra)));

    	return poisFiltrados; 
    }
    
    
}
