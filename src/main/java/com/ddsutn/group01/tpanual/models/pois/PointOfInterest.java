package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class PointOfInterest {
    private Integer id;
    protected String name;
    protected Point point;
    protected List<String> palabrasClaves;

    public PointOfInterest(Integer id, String name, Point point) {
        this.id = id;
        this.name  = name;
        this.point = point;
        palabrasClaves = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public final void agregarPalabraClave(String unaPalabra) {
    	palabrasClaves.add(unaPalabra);
    }

    public final Boolean palabraEsta(String unaPalabra) {
    	return palabrasClaves.contains(unaPalabra) || cumpleCondicion(unaPalabra);
    }

	public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < criterioDeCercania();
    }

    public abstract Boolean estaDisponible(DateTime unHorario);

    protected abstract Boolean cumpleCondicion(String unaPalabra);

    protected Double criterioDeCercania() {
        return 0.5;
    }
}
