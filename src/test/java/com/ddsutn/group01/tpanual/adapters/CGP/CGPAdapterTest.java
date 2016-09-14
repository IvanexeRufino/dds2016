package com.ddsutn.group01.tpanual.adapters.CGP;

import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class CGPAdapterTest {
    private List<PointOfInterest> listaReal;
    private CentrosDeGestionYParticipacion centroPosta;

    @Before
    public void init() {
        ArrayList<CentroDTO> unaListaDeCentrosDTO = new ArrayList<>();

        ArrayList<String> zonasIncluidas = new ArrayList<>();
        zonasIncluidas.add("palermo");
        zonasIncluidas.add("belgrano");

        DiasDeServicio lunesOchoHoras = new DiasDeServicio(1,8,0,16,0);
        ArrayList<DiasDeServicio> unosDias = new ArrayList<>();
        unosDias.add(lunesOchoHoras);

        ServicioDTO pagos = new ServicioDTO("pagos", unosDias);
        ServicioDTO cobros = new ServicioDTO("cobros", unosDias);

        ArrayList<ServicioDTO> servicios = new ArrayList<>();
        servicios.add(cobros);
        servicios.add(pagos);

        CentroDTO centroDTO1 = new CentroDTO(4, zonasIncluidas, "pepito", "junin 45", "45698541", servicios);
        CentroDTO centroDTO2 = new CentroDTO(1, zonasIncluidas, "juana", "rosario 27", "89652145", servicios);

        unaListaDeCentrosDTO.add(centroDTO1);
        unaListaDeCentrosDTO.add(centroDTO2);

        listaReal = CGPAdapter.adapt(unaListaDeCentrosDTO);
    }

    @Test
    public void cGP1EstaDisponibleElLunesALas12() {
        Polygon poligono = new Polygon();
        CentrosDeGestionYParticipacion unCentro = (CentrosDeGestionYParticipacion) listaReal.get(0);
        centroPosta = new CentrosDeGestionYParticipacion("centroTransformado", poligono);
        LocalTime horaDeApertura = new LocalTime(8, 0);
        LocalTime horaDeCierre = new LocalTime(16, 0);
        Horario horaAtencionLunes = new Horario(DayOfWeek.MONDAY, horaDeApertura, horaDeCierre);
        HorariosDeAtencion horariosDeAtencion = new HorariosDeAtencion();
        horariosDeAtencion.agregarHorario(horaAtencionLunes);
        Servicio pagos = new Servicio("pagos",horariosDeAtencion);
        Servicio cobros = new Servicio("cobros",horariosDeAtencion);
        centroPosta.agregarUnServicio(cobros);
        centroPosta.agregarUnServicio(pagos);

        Assert.assertEquals(unCentro.getName(), centroPosta.getName());
        Assert.assertEquals(unCentro.getServicios().get(0).getNombre(), centroPosta.getServicios().get(0).getNombre());
        Assert.assertEquals(unCentro.getServicios().get(1).getNombre(), centroPosta.getServicios().get(1).getNombre());
        Assert.assertEquals(unCentro.getServicios().get(0).getHorariosDeAtencion().getHorarios().get(0).getDia(),
                            centroPosta.getServicios().get(0).getHorariosDeAtencion().getHorarios().get(0).getDia());
        Assert.assertEquals(unCentro.getServicios().get(0).getHorariosDeAtencion().getHorarios().get(0).getHoraDeApertura(),
                            centroPosta.getServicios().get(0).getHorariosDeAtencion().getHorarios().get(0).getHoraDeApertura());
        Assert.assertEquals(unCentro.getServicios().get(0).getHorariosDeAtencion().getHorarios().get(0).getHoraDeCierre(),
                            centroPosta.getServicios().get(0).getHorariosDeAtencion().getHorarios().get(0).getHoraDeCierre());
   }
}
