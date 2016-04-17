package com.ddsutn.group01.tpanual.models.pois;

import java.awt.Point;
import java.awt.geom.Point2D;

public class ParadaColectivo extends PointOfInterest {
	
    public ParadaColectivo(String name, Object direccion, Point2D coordenada) {
        super(name, direccion, coordenada);
    }
    
    public Boolean cercanoA (Usuario usuario) {
    	double resultado = Point2D.distance(this.coordenada.getX(), this.coordenada.getY(), usuario.posicion.getX(),usuario.posicion.getY());
    	return resultado <1;
    	
    }
    
    

	
}
