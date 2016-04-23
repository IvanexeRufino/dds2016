package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.PalabrasClaves;


public abstract class PointOfInterest {
    protected String name;
    protected Point point;
    protected PalabrasClaves palabrasClaves;

    public PointOfInterest(String name, Point point) {
    	this.name  = name;
        this.point = point;
        this.palabrasClaves = new PalabrasClaves();
    }

    public void agregarPalabraClave(String unaPalabra){
    	palabrasClaves.agregarPalabraClave(unaPalabra);
    }

    public Boolean palabraEsta(String unaPalabra){
    	return palabrasClaves.buscarPalabra(unaPalabra);
    }

    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < criterioDeCercania();
    }

    public String getName() {
        return name;
    }

    public abstract Boolean estaDisponible(DateTime unHorario);

    protected Double criterioDeCercania() {
        return 0.5;
    }
}
