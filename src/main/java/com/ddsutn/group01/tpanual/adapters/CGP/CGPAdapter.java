package com.ddsutn.group01.tpanual.adapters.CGP;

import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.joda.time.LocalTime;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CGPAdapter {
    static public List<PointOfInterest> adapt(List<CentroDTO> result) {
        return result.stream().map(centro->modelarCGP(centro))
                              .collect(Collectors.toList());
    }

    static private CentrosDeGestionYParticipacion modelarCGP(CentroDTO unCentro) {
        Polygon poligono = new Polygon();
        CentrosDeGestionYParticipacion centro = new CentrosDeGestionYParticipacion("centroTransformado", poligono);
        centro.setServicios(unCentro.getServicios().stream().map(unServicioDTO->modelarServicio(unServicioDTO))
                                                            .collect(Collectors.toList()));
        return centro;
    }

    static private Servicio modelarServicio(ServicioDTO unServicioDTO) {
        HorariosDeAtencion unosHorarios = new HorariosDeAtencion();
        unosHorarios.setHorarios(unServicioDTO.getListaDeDias().stream().map(unHorario->modelarHorario(unHorario))
                                               .collect(Collectors.toList()));
        return new Servicio(unServicioDTO.getNombre(), unosHorarios);
    }

    static private Horario modelarHorario(DiasDeServicio unDia) {
        LocalTime horarioDeEntrada = new LocalTime(unDia.getHoraDesde(), unDia.getMinutoDesde());
        LocalTime horarioDeSalida = new LocalTime(unDia.getHoraHasta(), unDia.getMinutoHasta());
        return new Horario(DayOfWeek.of(unDia.getNumeroDeDia()), horarioDeEntrada, horarioDeSalida);
    }
}
