package com.ddsutn.group01.tpanual.models.pois;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;



public abstract class PointOfInterest {
    protected String name;
    protected Point point;
    protected List<String> palabrasClaves;

    public PointOfInterest(String name, Point point) {
    	this.name  = name;
        this.point = point;
        palabrasClaves = new ArrayList<>();
    }

    public void agregarPalabraClave(String unaPalabra){
    	palabrasClaves.add(unaPalabra);
    }

    public Boolean palabraEsta(String unaPalabra){
    	return palabrasClaves.contains(unaPalabra) || cumpleCondicion(unaPalabra);
    }

    public Boolean cumpleCondicion(String unaPalabra) {
		return false;
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
