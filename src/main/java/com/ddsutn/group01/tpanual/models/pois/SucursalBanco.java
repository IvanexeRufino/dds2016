package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import org.joda.time.LocalTime;
import org.mongodb.morphia.annotations.Embedded;
import org.uqbar.geodds.Point;

import javax.persistence.Entity;
import java.time.DayOfWeek;
import java.util.Arrays;

@Embedded
@Entity
public class SucursalBanco extends PoiConServicios {

    public SucursalBanco() {}

    public SucursalBanco(String name, Point point) {
        super(name, point);
        agregarUnServicio(servicioDeAtencionAlCliente());
    }

    private Servicio servicioDeAtencionAlCliente() {
        HorariosDeAtencion horarioBancario = new HorariosDeAtencion();
        LocalTime horaDeApertura = new LocalTime(10, 0);
        LocalTime horaDeCierre = new LocalTime(15, 0);

        Arrays.stream(DayOfWeek.values()).filter(this::esDiaDeSemana).forEach(day -> {
            Horario horario = new Horario(day, horaDeApertura, horaDeCierre);
            horarioBancario.agregarHorario(horario);
        });

        return new Servicio("atencion al cliente", horarioBancario);
    }

    private Boolean esDiaDeSemana(DayOfWeek day) {
        return (day.getValue() >= DayOfWeek.MONDAY.getValue()) && (day.getValue() <= DayOfWeek.FRIDAY.getValue());
    }

}
