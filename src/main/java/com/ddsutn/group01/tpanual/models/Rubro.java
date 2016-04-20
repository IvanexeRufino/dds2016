package com.ddsutn.group01.tpanual.models;

public class Rubro {
    private double radioDeCercania;
    private String nombre;
    
    public Rubro(String unNombre, double unRadio){
    	this.nombre=unNombre;
    	this.radioDeCercania=unRadio;
    }

    Rubro(double radioDeCercania) {
        this.radioDeCercania = radioDeCercania;
    }

    public double getRadioDeCercania() {
        return radioDeCercania;
    }
    public String getNombre()
    {
    	return nombre;
    }
}