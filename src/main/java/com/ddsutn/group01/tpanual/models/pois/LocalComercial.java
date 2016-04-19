package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.Rubro;

import java.time.LocalDateTime;

import org.uqbar.geodds.Point;

public class LocalComercial extends PointOfInterest {
    private Rubro rubro;
    private Horario horario;

    public LocalComercial(String name, Point point, Rubro rubro,Horario unHorario) {
        super(name, point);
        this.rubro = rubro;
        this.horario = unHorario;
    }

    @Override
    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < rubro.getRadioDeCercania();
    }
    public Boolean estaDisponible(LocalDateTime unHorario)
    {
    	return horario.estaDisponible(unHorario);
    }
}
