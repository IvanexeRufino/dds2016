package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import javax.persistence.*;

@Entity
public class LocalComercial extends PointOfInterest {
    @Column
    @Enumerated(EnumType.STRING)
	private Rubro rubro;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name="horarios_de_atencion_id")
    private HorariosDeAtencion horarioDeAtencion;

    public LocalComercial(String name, Point point, Rubro rubro, HorariosDeAtencion horarioDeAtencion) {
        super(name, point);
        this.rubro = rubro;
        this.horarioDeAtencion = horarioDeAtencion;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public HorariosDeAtencion getHorarioDeAtencion() {
        return horarioDeAtencion;
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
