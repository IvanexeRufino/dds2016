package com.ddsutn.group01.tpanual.models;

import com.ddsutn.group01.tpanual.PersistentRecord;
import com.ddsutn.group01.tpanual.db.HorariosConverter;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HorariosDeAtencion extends PersistentRecord {
    @Column
    @Convert(converter = HorariosConverter.class)
    private List<Horario> horarios;

    public HorariosDeAtencion() {
        horarios = new ArrayList<>();
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void agregarHorario(Horario horario) {
        horarios.add(horario);
    }

    public Boolean estaDisponible(DateTime ciertoMomento) {
        return horarios.stream().anyMatch(horario -> horario.estaDisponible(ciertoMomento));
    }

    public void setHorarios(List<Horario> unosHorarios) {
        horarios = unosHorarios;
    }
}
