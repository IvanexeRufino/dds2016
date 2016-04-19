package com.ddsutn.group01.tpanual.models.pois;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import org.uqbar.geodds.Point;
import java.time.DayOfWeek;
import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.Servicio;

public class SucursalBanco extends PointOfInterest {
    private ArrayList<Servicio> servicios;
    private Horario horarioBancario;
    
    public SucursalBanco(String name, Point point) {
        super(name, point);
        this.servicios = new ArrayList<Servicio>();
        this.horarioBancario = new Horario();
        LocalTime horarioDeEntrada= LocalTime.of(10, 00);
        LocalTime horarioDeSalida= LocalTime.of(15, 00);
        this.horarioBancario.agregarHorario(DayOfWeek.MONDAY,horarioDeEntrada,horarioDeSalida);
        this.horarioBancario.agregarHorario(DayOfWeek.TUESDAY,horarioDeEntrada,horarioDeSalida);
        this.horarioBancario.agregarHorario(DayOfWeek.WEDNESDAY,horarioDeEntrada,horarioDeSalida);
        this.horarioBancario.agregarHorario(DayOfWeek.THURSDAY,horarioDeEntrada,horarioDeSalida);
        this.horarioBancario.agregarHorario(DayOfWeek.FRIDAY,horarioDeEntrada,horarioDeSalida);
    }
    public void agregarUnServicio(String unServicio)
    {
    	Servicio servicio = new Servicio(unServicio,horarioBancario);
    	servicios.add(servicio);
    }
    public Boolean estaDisponible(String unServicio,LocalDateTime unHorario)
    {
    Servicio servicioBuscado = servicios.stream().filter(Servicio->Servicio.getNombre().equals(unServicio))
    .findFirst()
    .get();
    return servicioBuscado.estaDisponible(unHorario);
    }
    public Boolean estaDisponible(LocalDateTime unHorario)
    {
    	return servicios.stream().anyMatch(Servicio->Servicio.estaDisponible(unHorario));
    }
}