package com.ddsutn.group01.tpanual.models.pois;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import javax.persistence.Entity;

@Entity
public class CentrosDeGestionYParticipacion extends PoiConServicios {
    private Polygon zonaDelimitada;

    public CentrosDeGestionYParticipacion(Integer id, String name, Polygon zonaDelimitada) {
        super(name, null);
        this.zonaDelimitada = zonaDelimitada;
    }

    @Override
    public Boolean estaCercaDe(Point point) {
        return zonaDelimitada.isInside(point);
    }
}
