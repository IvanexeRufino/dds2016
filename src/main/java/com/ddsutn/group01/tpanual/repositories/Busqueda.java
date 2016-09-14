package com.ddsutn.group01.tpanual.repositories;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

@Entity
public class Busqueda {
	
	@Id @GeneratedValue
	private long id;
	@Column (length = 50)
	private String criteria;
	@ManyToMany
	private List<PointOfInterest> resultados;

	@SuppressWarnings("unused")
	private Busqueda() {}
	
	public Busqueda(String parametros, List<PointOfInterest> results) {
		this.criteria = parametros;
		this.resultados = results;
	}
	

}
