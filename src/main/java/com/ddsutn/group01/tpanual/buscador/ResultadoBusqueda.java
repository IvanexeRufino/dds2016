package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.db.PersistentRecord;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
public class ResultadoBusqueda extends PersistentRecord {

    @Id
    private String searchText;

    @OneToMany
    private List<PointOfInterest> resultados;
    
    @Column(length=50)
    private String username;
    
    private DateTime fecha;

    @SuppressWarnings("unused")
    private ResultadoBusqueda() {
    }

    public ResultadoBusqueda(String searchText, List<PointOfInterest> results, String username) {
        this.searchText = searchText;
        this.resultados = results;
        this.username = username;
        this.fecha = new DateTime();
    }
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public DateTime getFecha() {
		return fecha;
	}

	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}

	public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<PointOfInterest> getResultados() {
        return resultados;
    }

    public void setResultados(List<PointOfInterest> resultados) {
        this.resultados = resultados;
    }

}
