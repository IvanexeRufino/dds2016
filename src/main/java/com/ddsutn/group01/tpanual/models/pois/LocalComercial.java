package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

public class LocalComercial extends PointOfInterest {
    private Rubro rubro;
    private HorariosDeAtencion horarioDeAtencion;

    public LocalComercial(String name, Point point, Rubro rubro, HorariosDeAtencion horarioDeAtencion) {
        super(name, point);
        this.rubro = rubro;
        this.horarioDeAtencion = horarioDeAtencion;
    }

    @Override
    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < rubro.getRadioDeCercania();
    }

    @Override
    public Boolean estaDisponible(DateTime unHorario) {
    	return horarioDeAtencion.estaDisponible(unHorario);
    }

    public Boolean palabraEsta(String unaPalabra){
    	return rubro.getNombre().equals(unaPalabra) || super.palabraEsta(unaPalabra);
    }
}
