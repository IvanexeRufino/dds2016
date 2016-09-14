package com.ddsutn.group01.tpanual.repositories;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

@Entity
public class Busqueda {
	
	@Id @GeneratedValue
	private Integer id;
	@Column (length = 50)
	private String criteria;
	//no esta persistido POI
	@Transient
	private List<PointOfInterest> resultados;

	@SuppressWarnings("unused")
	private Busqueda() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public List<PointOfInterest> getResultados() {
		return resultados;
	}

	public void setResultados(List<PointOfInterest> resultados) {
		this.resultados = resultados;
	}

	public Busqueda(String parametros, List<PointOfInterest> results) {
		this.criteria = parametros;
		this.resultados = results;
	}
	

}
