package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Servicio;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import java.util.ArrayList;

public class CentrosDeGestionYParticipacion extends PointOfInterest {
    private Polygon zonaDelimitada;
    private ArrayList<Servicio> servicios;

    public CentrosDeGestionYParticipacion(String name, Polygon zonaDelimitada) {
        super(name, null);
        this.zonaDelimitada = zonaDelimitada;
        this.servicios = new ArrayList<Servicio>();
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
        Servicio servicioBuscado = servicios.stream().filter(servicio -> servicio.getNombre().contains(unServicio))
        .findFirst().get();

        return servicioBuscado.estaDisponible(unHorario);
    }
}
