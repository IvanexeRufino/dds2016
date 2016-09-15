package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Servicio;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PoiConServicios extends PointOfInterest {
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Servicio> servicios;


    public PoiConServicios(String name, Point point) {
        super(name, point);
        servicios = new ArrayList<>();
    }

    public List<Servicio> getServicios() {
        return servicios;
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

    public void setServicios(List<Servicio> unosServicios) {
        servicios = unosServicios;
    }
}
