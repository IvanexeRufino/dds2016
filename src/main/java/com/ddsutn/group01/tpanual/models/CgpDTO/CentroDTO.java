package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.util.ArrayList;

import org.uqbar.geodds.Polygon;

import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;

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

	public ArrayList<ServicioDTO> getServicio() {
		return servicios;
	}
	
	public CentrosDeGestionYParticipacion modelar(){
	    //como obtengo el poligono?
	    ArrayList<Servicio> listaDeServicios = new ArrayList<Servicio>();
	    Polygon poligono = new Polygon();
	    CentrosDeGestionYParticipacion centro = new CentrosDeGestionYParticipacion(nroDeComuna, "centroTransformado", poligono);
	    servicios.forEach(unServicioDTO->listaDeServicios.add(unServicioDTO.modelar()));
	    centro.setServicios(listaDeServicios);
	    return centro;
	}
}