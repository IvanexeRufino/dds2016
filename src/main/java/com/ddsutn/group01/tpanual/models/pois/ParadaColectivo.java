package com.ddsutn.group01.tpanual.models.pois;

import java.awt.geom.Point2D;

public class ParadaColectivo extends PointOfInterest {
	
    public ParadaColectivo(String name, Object direccion, Point2D coordenada) {
        super(name, direccion, coordenada);
    }
    @Override
    public Boolean cercanoA (Usuario usuario) {
    	return this.coordenada.distance(usuario.posicion) <100; 	
    }
}
