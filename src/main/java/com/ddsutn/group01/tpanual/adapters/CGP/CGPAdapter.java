package com.ddsutn.group01.tpanual.adapters.CGP;

import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.joda.time.LocalTime;
import org.uqbar.geodds.Polygon;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class CGPAdapter {
    static public ArrayList<PointOfInterest> adapt(ArrayList<CentroDTO> listaCentroDTO) {
        ArrayList<PointOfInterest> listaCgp = new ArrayList<>();
        listaCentroDTO.forEach(centro->listaCgp.add(modelarCGP(centro)));
        return listaCgp;
    }

    static private CentrosDeGestionYParticipacion modelarCGP(CentroDTO unCentro){
        //como obtengo el poligono?
        ArrayList<Servicio> listaDeServicios = new ArrayList<>();
        Polygon poligono = new Polygon();
        CentrosDeGestionYParticipacion centro = new CentrosDeGestionYParticipacion(unCentro.getNroDeComuna(), "centroTransformado", poligono);
        unCentro.getServicios().forEach(unServicioDTO->listaDeServicios.add(modelarServicio(unServicioDTO)));
        centro.setServicios(listaDeServicios);
        return centro;
    }

    static private Servicio modelarServicio(ServicioDTO unServicioDTO){
        HorariosDeAtencion unosHorarios = new HorariosDeAtencion();
        unServicioDTO.getListaDeDias().forEach(unHorario->unosHorarios.agregarHorario(modelarHorario(unHorario)));
        return new Servicio(unServicioDTO.getNombre(), unosHorarios);
    }

    static private Horario modelarHorario(DiasDeServicio unDia){
        LocalTime horarioDeEntrada = new LocalTime(unDia.getHoraDesde(), unDia.getMinutoDesde());
        LocalTime horarioDeSalida = new LocalTime(unDia.getHoraHasta(), unDia.getMinutoHasta());
        return new Horario(DayOfWeek.of(unDia.getNumeroDeDia()), horarioDeEntrada, horarioDeSalida);
    }
}
