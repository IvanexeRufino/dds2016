package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

@Entity
public class LocalComercial extends PointOfInterest {
    @ManyToOne
    @Column(name="Rubro")
    @Enumerated
	private Rubro rubro;
    
    @ManyToOne
    private HorariosDeAtencion horarioDeAtencion;

    public LocalComercial(String name, Point point, Rubro rubro, HorariosDeAtencion horarioDeAtencion) {
        super(name, point);
        this.rubro = rubro;
        this.horarioDeAtencion = horarioDeAtencion;
    }

    @Override
    public Boolean estaDisponible(DateTime unHorario) {
        return horarioDeAtencion.estaDisponible(unHorario);
    }

    public Boolean cumpleCondicion(String unaPalabra) {
        return rubro.getNombre().equals(unaPalabra);
    }

    @Override
    protected Double criterioDeCercania() {
        return rubro.getRadioDeCercania();
    }

    public void actualizarPalabrasClaves (String palabras) {
    	palabrasClaves.clear();
    	String [] nuevasPalabras = palabras.split("\\s+");
    	for (String palabra : nuevasPalabras) {
    		palabrasClaves.add(palabra);
    	}
    }
}
