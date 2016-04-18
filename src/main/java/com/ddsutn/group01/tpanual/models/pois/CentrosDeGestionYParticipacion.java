package com.ddsutn.group01.tpanual.models.pois;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class CentrosDeGestionYParticipacion extends PointOfInterest {
    private Polygon zonaDelimitada;

    public CentrosDeGestionYParticipacion(String name, Point point, Polygon zonaDelimitada) {
        super(name, point);
        this.zonaDelimitada = zonaDelimitada;
    }

    @Override
    public Boolean estaCercaDe(Point point) {
        return zonaDelimitada.isInside(point);
    }
}
