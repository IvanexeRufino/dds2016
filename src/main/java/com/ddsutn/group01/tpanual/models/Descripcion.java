package com.ddsutn.group01.tpanual.models;

import java.util.ArrayList;

public class Descripcion {
	
	private ArrayList<String> descripciones;

	public Descripcion() {
        descripciones = new ArrayList<>();
    }
	
	public ArrayList<String> getDescripcion() {
		return descripciones;
	}
	
	public void agregarDescripcion (String unaPalabra) {
		descripciones.add(unaPalabra);
	}
	
	public boolean buscarPalabra (String unaPalabra){
		return descripciones.stream()
                .anyMatch(descripcion -> descripcion == (unaPalabra));
		
		
	}
	
	
	
	
	
	

	
	

}
