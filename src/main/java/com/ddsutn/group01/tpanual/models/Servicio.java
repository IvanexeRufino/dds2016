package com.ddsutn.group01.tpanual.models;

import com.ddsutn.group01.tpanual.PersistentRecord;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class Servicio extends PersistentRecord {
    @Column
    private String nombre;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name="horarios_de_atencion_id")
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
