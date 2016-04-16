package com.ddsutn.group01.tpanual.model.pois;

public abstract class PointOfInterest {
    private String name;
    private Object direccion;
    private Object coordenada;

    public PointOfInterest(String name, Object direccion, Object coordenada) {
        this.name = name;
        this.direccion = direccion;
        this.coordenada = coordenada;
    }

    // TODO
    public Boolean esValido() {
        return false;
    }

    // TODO
    public Boolean cercanoA() {
        return false;
    }
}
