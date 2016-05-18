package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Servicio;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class PoiConServicios extends PointOfInterest {
    private List<Servicio> servicios;

    public PoiConServicios(String name, Point point) {
        super(name, point);
        servicios = new ArrayList<>();
    }

    @Override
    public Boolean estaDisponible(DateTime horario) {
        return servicios.stream().anyMatch(servicio -> servicio.estaDisponible(horario));
    }

    public Boolean estaDisponible(DateTime unHorario, String nombreServicio) {
        return servicios.stream()
                .filter(servicio -> servicio.getNombre().equals(nombreServicio))
                .map(servicio -> servicio.estaDisponible(unHorario))
                .findFirst()
                .orElse(false);
    }

    @Override
    protected Boolean cumpleCondicion(String unaPalabra) {
        return servicios.stream().anyMatch(servicio -> servicio.getNombre().contains(unaPalabra));
    }

    public void agregarUnServicio(Servicio servicio) {
        servicios.add(servicio);
    }
    
    public void setServicios(ArrayList<Servicio> unosServicios){
        servicios=unosServicios;
    }
}
