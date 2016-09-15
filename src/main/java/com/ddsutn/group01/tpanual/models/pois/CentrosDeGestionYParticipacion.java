package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.db.PolygonConverter;
import org.uqbar.geodds.Point;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "centros_de_gestion_y_participacion")
public class CentrosDeGestionYParticipacion extends PoiConServicios {
    @Column
    @Convert(converter = PolygonConverter.class)
    private Polygon zonaDelimitada;

    @SuppressWarnings("unused")
    protected CentrosDeGestionYParticipacion() {}

    public CentrosDeGestionYParticipacion(String name, Polygon zonaDelimitada) {
        super(name, null);
        this.zonaDelimitada = zonaDelimitada;
    }

    public Polygon getZonaDelimitada() {
        return zonaDelimitada;
    }

    @Override
    public Boolean estaCercaDe(Point point) {
        return zonaDelimitada.isInside(point);
    }
}
