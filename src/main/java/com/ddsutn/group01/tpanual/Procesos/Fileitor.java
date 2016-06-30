package com.ddsutn.group01.tpanual.Procesos;


import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class Fileitor {
	private String archivo;	
	
	public Fileitor(String archivo) {
		this.archivo = archivo;
	}

	public void disarm () {
		
	//algo con recursividad

		//otraLista.forEach(linea -> this.basicDisarm(linea));
	}
	
	public void basicDisarm (String unalinea) {
		String [] aline = unalinea.split(";");
        String nlocal = aline [0];
        String pclaves = aline [1];
        
        PointOfInterest poiBuscado = PoiRepository.getInstance()
                .getOrigenLocal().getAll().stream()
                .filter(poi -> poi.getName().equals(nlocal))
                .findFirst().get();
        poiBuscado.actualizarPalabrasClaves(pclaves);
	}
}
