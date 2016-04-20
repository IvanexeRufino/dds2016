package com.ddsutn.group01.tpanual.models;

import java.util.ArrayList;

import java.util.List;

public class PalabrasClaves {
	
	private List<String> palabras;

	public PalabrasClaves() {
		palabras = new ArrayList<>();
	    }
	  
	public List<String> getDescripcion() {
		return palabras;
	}
	
	public void agregarPalabraClave (String unaPalabra) {
		palabras.add(unaPalabra);
	}
	
	public boolean buscarPalabra (String unaPalabra){	
	return 	palabras.stream()
			.anyMatch(palabraClave -> palabraClave.equals(unaPalabra));
	}

}