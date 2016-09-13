package com.ddsutn.group01.tpanual.models.pois;

import javax.persistence.Entity;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

@Entity
public class CentrosDeGestionYParticipacion extends PoiConServicios {
    private Polygon zonaDelimitada;

    public CentrosDeGestionYParticipacion(Integer id, String name, Polygon zonaDelimitada) {
        super(id, name, null);
        this.zonaDelimitada = zonaDelimitada;
    }

    @Override
    public Boolean estaCercaDe(Point point) {
        return zonaDelimitada.isInside(point);
    }
}
