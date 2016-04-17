package com.ddsutn.group01.tpanual.models.pois;

import java.awt.geom.Point2D;

public class Usuario {

	protected Point2D posicion;
	
	public Usuario (Point2D posicion)
	{ this.posicion = posicion;
}
	
	public Boolean estaCercaDe (PointOfInterest unPunto){
		return unPunto.cercanoA(this);
	}
}

