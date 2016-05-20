package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.time.DayOfWeek;
import java.util.ArrayList;

import org.joda.time.LocalTime;
import org.uqbar.geodds.Polygon;

import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

public class CgpAdapter {
    public ArrayList<PointOfInterest> parsear(ArrayList<CentroDTO> listaCentroDTO) {
        ArrayList<PointOfInterest> listaCgp = new ArrayList<>();
        listaCentroDTO.forEach(centro->listaCgp.add(this.modelarCGP(centro)));
        return listaCgp;
    }
    
    public CentrosDeGestionYParticipacion modelarCGP(CentroDTO unCentro){
        //como obtengo el poligono?
        ArrayList<Servicio> listaDeServicios = new ArrayList<Servicio>();
        Polygon poligono = new Polygon();
        CentrosDeGestionYParticipacion centro = new CentrosDeGestionYParticipacion(unCentro.getNroDeComuna(), "centroTransformado", poligono);
        unCentro.getServicios().forEach(unServicioDTO->listaDeServicios.add(this.modelarServicio(unServicioDTO)));
        centro.setServicios(listaDeServicios);
        return centro;
    }
    
    public Servicio modelarServicio(ServicioDTO unServicioDTO){
        HorariosDeAtencion unosHorarios = new HorariosDeAtencion();
        unServicioDTO.getListaDeDias().forEach(unHorario->unosHorarios.agregarHorario(this.modelarHorario(unHorario)));
        Servicio unServicio = new Servicio(unServicioDTO.getNombre(), unosHorarios);
        return unServicio;
    }
    
    public Horario modelarHorario(DiasDeServicio unDia){
        LocalTime horarioDeEntrada = new LocalTime(unDia.getHoraDesde(), unDia.getMinutoDesde());
        LocalTime horarioDeSalida = new LocalTime(unDia.getHoraHasta(), unDia.getMinutoHasta());
        Horario horario = new Horario(DayOfWeek.of(unDia.getNumeroDeDia()), horarioDeEntrada, horarioDeSalida);
        return horario;
    }
}