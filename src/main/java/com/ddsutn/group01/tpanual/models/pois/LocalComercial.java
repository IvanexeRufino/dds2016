package com.ddsutn.group01.tpanual.models.pois;

import java.awt.geom.Point2D;

public class LocalComercial extends PointOfInterest {
	
	private int radioDeCercania;
	
    public LocalComercial(String name, Object direccion,int radioDeCercania, Point2D coordenada) {
        super(name, direccion, coordenada);
        this.radioDeCercania = radioDeCercania;
    }
    @Override
    public Boolean cercanoA (Usuario usuario) {
    	return this.coordenada.distance(usuario.posicion) <= this.radioDeCercania;
    }
}
