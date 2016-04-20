package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.uqbar.geodds.Point;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class SucursalBanco extends PointOfInterest {
    private List<Servicio> servicios;

    public SucursalBanco(String name, Point point) {
        super(name, point);
        servicios = new ArrayList<>();
        agregarUnServicio(servicioDeAtencionAlCliente());
    }

    @Override
    public Boolean estaDisponible(DateTime unHorario) {
        return servicios.stream().anyMatch(Servicio->Servicio.estaDisponible(unHorario));
    }

    public void agregarUnServicio(Servicio unServicio) {
        servicios.add(unServicio);
    }

    public Boolean estaDisponible(String unServicio, DateTime unHorario) {
        Servicio servicioBuscado = servicios.stream().filter(Servicio->Servicio.getNombre().equals(unServicio))
        .findFirst().get();
        return servicioBuscado.estaDisponible(unHorario);
    }

    private Servicio servicioDeAtencionAlCliente() {
        HorariosDeAtencion horarioBancario = new HorariosDeAtencion();
        LocalTime horarioDeEntrada= new LocalTime(10, 00);
        LocalTime horarioDeSalida= new LocalTime(15, 00);
        horarioBancario.agregarHorario(DayOfWeek.MONDAY, horarioDeEntrada, horarioDeSalida);
        horarioBancario.agregarHorario(DayOfWeek.TUESDAY, horarioDeEntrada, horarioDeSalida);
        horarioBancario.agregarHorario(DayOfWeek.WEDNESDAY, horarioDeEntrada, horarioDeSalida);
        horarioBancario.agregarHorario(DayOfWeek.THURSDAY, horarioDeEntrada, horarioDeSalida);
        horarioBancario.agregarHorario(DayOfWeek.FRIDAY, horarioDeEntrada, horarioDeSalida);

        return new Servicio("atencion al cliente", horarioBancario);
    }
}
