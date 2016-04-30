package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Servicio;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CentrosDeGestionYParticipacion extends PointOfInterest {
    private Polygon zonaDelimitada;
    private List<Servicio> servicios;

    public CentrosDeGestionYParticipacion(String name, Polygon zonaDelimitada) {
        super(name, null);
        this.zonaDelimitada = zonaDelimitada;
        servicios = new ArrayList<>();
    }

    @Override
    public Boolean estaCercaDe(Point point) {
        return zonaDelimitada.isInside(point);
    }

    @Override
    public Boolean estaDisponible(DateTime unHorario) {
        return servicios.stream().anyMatch(servicio -> servicio.estaDisponible(unHorario));
    }

    public void agregarUnServicio(Servicio unServicio) {
    	servicios.add(unServicio);
    }

    public Boolean estaDisponible(String unServicio, DateTime unHorario) {
    	 Optional<Servicio> servicioBuscado = servicios.stream().filter(Servicio->Servicio.getNombre().equals(unServicio))
    		        .findFirst();
    		        
    	 Boolean result;
    	 if (servicioBuscado.isPresent())
    	 		{Servicio elServicioBuscado= servicioBuscado.get();
    		     result = elServicioBuscado.estaDisponible(unHorario);}
    	 else {result = false;}    
    		        
    	 return result;
    }

    public Boolean cumpleCondicion(String unaPalabra) {
    	return servicios.stream().anyMatch(Servicio -> Servicio.getNombre().contains(unaPalabra));
    }
}
