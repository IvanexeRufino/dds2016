package com.ddsutn.group01.tpanual.models.pois;
import com.ddsutn.group01.tpanual.models.Comuna;
import java.awt.geom.Point2D;

public class CentrosDeGestionYParticipacion extends PointOfInterest {
	private Comuna comuna;
    public CentrosDeGestionYParticipacion(String name, Object direccion, Point2D coordenada,Comuna comuna) {
        super(name, direccion, coordenada);
        this.comuna=comuna;
    }
    @Override
    public Boolean cercanoA(Point2D posicion)
    {
    	return this.comuna.estaDentroDeZona(posicion);
    }
}