package com.ddsutn.group01.tpanual.Procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.google.common.io.Files;


public class ActualizarLocalComercial extends Proceso{
	private String bigstring;
   	private Fileitor fileitor;
	@Override
	
	public int ejecutar() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ActualizarLocalComercial(String bigstring) {
		this.bigstring = bigstring;
	}

	//public int ejecutar() throws Exception {
	//	this.fileitor = new Fileitor (bigstring);
	//	fileitor.ejecutar();
		//return ;
		

//}
}
