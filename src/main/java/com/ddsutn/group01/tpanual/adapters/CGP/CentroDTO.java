package com.ddsutn.group01.tpanual.adapters.CGP;

import java.util.ArrayList;

public class CentroDTO {
	private int nroDeComuna;
	private ArrayList <String> zonasIncluidas;
	private String nombreDirector;
	private String domicilio;
	private String telefono;
	private ArrayList <ServicioDTO> servicios = new ArrayList<ServicioDTO>();

	public CentroDTO(int nroDeComuna, ArrayList<String> zonasIncluidas, String nombreDirector, String domicilio,
        String telefono, ArrayList <ServicioDTO> servicios) {
		this.nroDeComuna = nroDeComuna;
		this.zonasIncluidas = zonasIncluidas;
		this.nombreDirector = nombreDirector;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.servicios = servicios;
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

	public ArrayList<ServicioDTO> getServicios() {
		return servicios;
	}
}
