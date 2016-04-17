package com.ddsutn.group01.tpanual.models.pois;

import java.awt.Point;
import java.awt.geom.Point2D;

public abstract class PointOfInterest {
    private String name;
    private Object direccion;
    protected Point2D coordenada;

    public PointOfInterest(String name, Object direccion, Point2D coordenada) {
        this.name = name;
        this.direccion = direccion;
        this.coordenada = coordenada;
    }
  
    // TODO
    public Boolean esValido() {
        return false;
    }   
  
}
