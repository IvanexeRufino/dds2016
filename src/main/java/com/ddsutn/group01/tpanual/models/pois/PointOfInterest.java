package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

public abstract class PointOfInterest {
    private String name;
    protected Point point;

    public PointOfInterest(String name, Point point) {
        this.name  = name;
        this.point = point;
    }

    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < 0.5;
    }

    public String getName() {
        return name;
    }

    public abstract Boolean estaDisponible(DateTime unHorario);
}
