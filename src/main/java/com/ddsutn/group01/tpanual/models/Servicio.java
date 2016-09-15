package com.ddsutn.group01.tpanual.models;

import org.joda.time.DateTime;

public class Servicio {
    private String nombre;
    private HorariosDeAtencion horariosDeAtencion;

    public Servicio(String nombre, HorariosDeAtencion horariosDeAtencion) {
        this.nombre = nombre;
        this.horariosDeAtencion = horariosDeAtencion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public HorariosDeAtencion getHorariosDeAtencion() {
        return horariosDeAtencion;
    }

    public Boolean estaDisponible(DateTime unHorario) {
        return horariosDeAtencion.estaDisponible(unHorario);
    }
}
