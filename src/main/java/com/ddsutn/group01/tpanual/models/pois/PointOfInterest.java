package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.Descripcion;


public abstract class PointOfInterest extends PoiMaster {
	
    private String name;
    protected Point point;
    protected Descripcion descripcion;
    
    public PointOfInterest(String name, Point point) {
       
    	this.name  = name;
        this.point = point;
        this.descripcion = new Descripcion();
 
    }
    
    public void agregarDescripcion (String unaPalabra){
    	descripcion.agregarDescripcion(unaPalabra); 
    }
    
    public  boolean palabraEsta (String unaPalabra){
		return descripcion.buscarPalabra(unaPalabra);
    }	
    
    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < 0.5;
    }

    public String getName() {
        return name;
    }
    
    public abstract Boolean estaDisponible(DateTime unHorario);
    
    
}
