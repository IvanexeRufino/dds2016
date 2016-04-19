package com.ddsutn.group01.tpanual.models.pois;
import com.ddsutn.group01.tpanual.models.Servicio;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class CentrosDeGestionYParticipacion extends PointOfInterest {
    private Polygon zonaDelimitada;
    private ArrayList<Servicio> servicios;

    public CentrosDeGestionYParticipacion(String name, Polygon zonaDelimitada) {
        super(name, null);
        this.zonaDelimitada = zonaDelimitada;
        this.servicios = new ArrayList<Servicio>();
    }
    
    public void agregarUnServicio(Servicio unServicio)
    {
    	servicios.add(unServicio);
    }
    @Override
    public Boolean estaCercaDe(Point point) {
        return zonaDelimitada.isInside(point);
    }
    
    public Boolean estaDisponible(String unServicio, LocalDateTime unHorario)
    {
    Servicio servicioBuscado = servicios.stream().filter(Servicio->Servicio.getNombre().contains(unServicio))
    .findFirst()
    .get();
    return servicioBuscado.estaDisponible(unHorario);
    }
    public Boolean estaDisponible(LocalDateTime unHorario)
    {
    	return servicios.stream().anyMatch(Servicio->Servicio.estaDisponible(unHorario));
    }
}
