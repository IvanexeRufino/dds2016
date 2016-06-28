package com.ddsutn.group01.tpanual.Procesos;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


import com.ddsutn.group01.tpanual.models.pois.LocalComercial;

import com.ddsutn.group01.tpanual.origins.LocalOrigin;


public class ActualizarLocalComercial extends Proceso{

	
	public ActualizarLocalComercial() {
	}

	public void ejecutar() throws IOException {
		LocalOrigin olocal = new LocalOrigin();
		
		 FileReader in = new FileReader("C:/entrega4.txt");
		    BufferedReader br = new BufferedReader(in);
		    String line;
		    while ((line = br.readLine()) != null) {
		        String [] aline = line.split(";");
		        String nombreLocal = aline [0];
		        String pclaves = aline [1];
		        
		        LocalComercial poiBuscado = (LocalComercial) olocal.getAll().stream().filter(poi -> poi.getName().equals(nombreLocal)).findFirst().get();
		        poiBuscado.actualizarPalabrasClaves(pclaves);
		        
		   }
		    
		    in.close();
		    
	}
	
}
