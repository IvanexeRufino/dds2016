package com.ddsutn.group01.tpanual.Procesos;


import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class Fileitor {
	private String archivo;
	private List<String> lalista;
	
	public Fileitor(String archivo) {
		this.archivo = archivo;
	}

	public List<String> disarm () {
		StringTokenizer tok = new StringTokenizer(archivo,"\n");
		int nrotokens = tok.countTokens();
		String [] splitArr = new String [nrotokens];
		for (int i=0;i<nrotokens;i++) {
			splitArr[i]=tok.nextToken();
		}
		
		List<String> lista = new ArrayList<String>(Arrays.asList(splitArr));
		return lista;
	}
	
	public void ejecutar() {
		lalista = this.disarm();
		lalista.stream().forEach(line-> this.basicDisarm(line));
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
