package com.ddsutn.group01.tpanual.Procesos;

public class ActualizarLocalComercial extends Proceso{
	private String bigstring;
   	private Fileitor fileitor;
   	private int contador;

	public ActualizarLocalComercial(String bigstring) {
		this.bigstring = bigstring;
	}   	
	
	public int ejecutar() throws Exception {
		this.fileitor = new Fileitor (bigstring);
		fileitor.ejecutar();		
		return 0;
	}
}
