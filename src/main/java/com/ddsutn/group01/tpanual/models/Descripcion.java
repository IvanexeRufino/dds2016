package com.ddsutn.group01.tpanual.models;

import java.util.ArrayList;
import java.util.List;

public class Descripcion {
	
	private List<String> descripciones;

	public Descripcion() {
	        descripciones = new ArrayList<>();
	    }
	  
	public List<String> getDescripcion() {
		return descripciones;
	}
	
	public void agregarDescripcion (String unaPalabra) {
		descripciones.add(unaPalabra);
	}
	
	public boolean buscarPalabra (String unaPalabra){	
	return 	descripciones.stream()
			.anyMatch(descripcion -> descripcion == (unaPalabra));
	
	}

	
	
	
	
	
	

	
	

}
