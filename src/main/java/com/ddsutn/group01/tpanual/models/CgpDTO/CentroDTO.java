package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.util.ArrayList;

public class CentroDTO {
	private int nroDeComuna;
	private ArrayList <String> zonasIncluidas;
	private String nombreDirector;
	private String domicilio;
	private String telefono;
	private ServicioDTO servicio;
	
	public CentroDTO(int nroDeComuna, ArrayList<String> zonasIncluidas, String nombreDirector, String domicilio,
			String telefono, ServicioDTO servicio) {
		super();
		this.nroDeComuna = nroDeComuna;
		this.zonasIncluidas = zonasIncluidas;
		this.nombreDirector = nombreDirector;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.servicio = servicio;
	}

	public int getNroDeComuna() {
		return nroDeComuna;
	}

	public ArrayList<String> getZonasIncluidas() {
		return zonasIncluidas;
	}

	public String getNombreDirector() {
		return nombreDirector;
	}
	
	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

}

	