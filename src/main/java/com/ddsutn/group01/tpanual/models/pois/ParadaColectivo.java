package com.ddsutn.group01.tpanual.models.pois;

import org.uqbar.geodds.Point;

public class ParadaColectivo extends PointOfInterest {
    public ParadaColectivo(String name, Point point) {
        super(name, point);
    }

    @Override
    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < 0.1;
    }
    public Boolean estaDisponible()
    {
    	return true;
    }
}
