package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

public class LocalComercial extends PointOfInterest {
    private Rubro rubro;
    private HorariosDeAtencion horarioDeAtencion;

    public LocalComercial(Integer id, String name, Point point, Rubro rubro, HorariosDeAtencion horarioDeAtencion) {
        super(id, name, point);
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
