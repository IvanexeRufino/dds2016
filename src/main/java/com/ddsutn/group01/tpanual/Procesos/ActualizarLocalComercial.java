package com.ddsutn.group01.tpanual.Procesos;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;


public class ActualizarLocalComercial extends Proceso{
    private String file;
	private int contador;
    
	private void aumentarContador() {
	    contador = contador +1;
	}
	
	public ActualizarLocalComercial(String file) {
		this.file = file;
	}

	public int ejecutar() throws IOException {
		 FileReader in = new FileReader(file);
		 BufferedReader br = new BufferedReader(in);
		 String line;
		   while ((line = br.readLine()) != null) {
		       String [] aline = line.split(";");
		       String nombreLocal = aline [0];
		       String pclaves = aline [1];
		       
		       PointOfInterest poiBuscado = PoiRepository.getInstance()
		    		   						.getOrigenLocal().getAll().stream()
		    		   						.filter(poi -> poi.getName().equals(nombreLocal))
		    		   						.findFirst().get();
		       poiBuscado.actualizarPalabrasClaves(pclaves);		        
		   }
		   
		 in.close();	
		 br.close();
		 return contador;
	}	
}
