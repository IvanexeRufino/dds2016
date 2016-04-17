package com.ddsutn.group01.tpanual.models.pois;

import java.awt.geom.Point2D;

public class LocalComercial extends PointOfInterest {
	
	private int radioDeCercania;
	
    public LocalComercial(String name, Object direccion,int radioDeCercania, Point2D coordenada) {
        super(name, direccion, coordenada);
        this.radioDeCercania = radioDeCercania;
    }
    
    public Boolean cercanoA (Usuario usuario) {
    	double resultado = Point2D.distance(this.coordenada.getX(), this.coordenada.getY(), usuario.posicion.getX(),usuario.posicion.getY());
    	return resultado <= this.radioDeCercania;
    	
    }
}
