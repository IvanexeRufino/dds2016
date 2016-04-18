package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Rubro;
import org.uqbar.geodds.Point;

public class LocalComercial extends PointOfInterest {
    private Rubro rubro;

    public LocalComercial(String name, Point point, Rubro rubro) {
        super(name, point);
        this.rubro = rubro;
    }

    @Override
    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < rubro.getRadioDeCercania();
    }
    public Boolean estaDisponible()
    {
    	return true;
    }
}
