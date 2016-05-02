package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.Servicio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoiMasterTest {
    private ParadaColectivo paradaDel114;
    private LocalComercial buffet;
    private PoiMaster poiMaster;
    private List<PointOfInterest> listaDeResultados;
    private Rubro kiosco;
    private String palabraClave;
    private CentrosDeGestionYParticipacion cgpCaballito;
    private Servicio rentas;

    @Before
    public void init () {
        poiMaster = new PoiMaster();
        listaDeResultados = new ArrayList<>();

        // Mocks
        HorariosDeAtencion horariosDeAtencion = Mockito.mock(HorariosDeAtencion.class);
        Point point = Mockito.mock(Point.class);
        Polygon polygon = Mockito.mock(Polygon.class);

        palabraClave = "utn";

        // Paradas de colectivo
        paradaDel114 = new ParadaColectivo ("114", point);
        ParadaColectivo paradaDel7 = new ParadaColectivo ("7", point);
        paradaDel114.agregarPalabraClave(palabraClave);

        // Locales comerciales
        kiosco = Rubro.kiosco;
        Rubro muebleria = Rubro.muebleria;
        Rubro libreriaEscolar= Rubro.libreriaEscolar;

        buffet = new LocalComercial("Albert Einstein", point, kiosco, horariosDeAtencion);
        buffet.agregarPalabraClave(palabraClave);
        LocalComercial unaMuebleria = new LocalComercial("Muebleria de Pepa", point, muebleria, horariosDeAtencion);
        LocalComercial unaLibreria = new LocalComercial("Libreria de Jose", point, libreriaEscolar, horariosDeAtencion);

        // Cgps
        cgpCaballito = new CentrosDeGestionYParticipacion ("cgp caballito", polygon);
        CentrosDeGestionYParticipacion cgpPalermo = new CentrosDeGestionYParticipacion ("cgp palermo", polygon);
        rentas = new Servicio ("rentas", horariosDeAtencion);
        Servicio asesoramiento = new Servicio ("asesoramiento", horariosDeAtencion);
        cgpCaballito.agregarUnServicio(rentas);
        cgpCaballito.agregarUnServicio(asesoramiento);
        cgpPalermo.agregarUnServicio(asesoramiento);

        ArrayList<PointOfInterest> pois = new ArrayList<>(Arrays.asList(
                paradaDel114, paradaDel7, buffet, unaMuebleria, unaLibreria, cgpCaballito, cgpPalermo));

        poiMaster = new PoiMaster(pois);
    }

    @Test
    public void buscarParadasDeColectivo() {
        listaDeResultados.add(paradaDel114);
        Assert.assertEquals("encuentra la parada de colectivo buscada",
                poiMaster.buscarPoi(paradaDel114.getName()), listaDeResultados);
    }

    @Test
    public void buscarLocalesComerciales() {
        listaDeResultados.add(buffet);
        Assert.assertEquals("encuentra los locales del rubro buscado",
                poiMaster.buscarPoi(kiosco.getNombre()), listaDeResultados);
    }

    @Test
    public void buscarPalabraClave() {
        listaDeResultados.add(paradaDel114);
        listaDeResultados.add(buffet);

        Assert.assertEquals("encuentra solo los pois que tengan la palabra clave buscada",
                poiMaster.buscarPoi(palabraClave), listaDeResultados);
    }

    @Test
    public void buscarPoiConServicio() {
        listaDeResultados.add(cgpCaballito);

        Assert.assertEquals("encuentra solo los pois que tegan el servicio buscado",
                poiMaster.buscarPoi(rentas.getNombre()), listaDeResultados);
    }
}
