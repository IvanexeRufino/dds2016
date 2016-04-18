package com.ddsutn.group01.tpanual.models;
import java.awt.Polygon;
import java.awt.geom.Point2D;

public class Comuna {
	private Polygon zona;
	public Comuna (Polygon unPoligono)
	{
		this.zona=unPoligono;
	}
	
	public Boolean estaDentroDeZona(Point2D unPunto)
	{
		return zona.contains(unPunto);
	}
}
