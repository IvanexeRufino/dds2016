package com.ddsutn.group01.tpanual.models.pois;

import org.uqbar.geodds.Point;

public class SucursalBanco extends PointOfInterest {
    public SucursalBanco(String name, Point point) {
        super(name, point);
    }
public Boolean estaDisponible()
{
	return true;
}
}
