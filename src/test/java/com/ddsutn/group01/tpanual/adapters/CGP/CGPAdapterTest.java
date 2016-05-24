package com.ddsutn.group01.tpanual.adapters.CGP;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CGPAdapterTest {
    private List<PointOfInterest> listaReal;
    
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
        PointOfInterest cgp1 = listaReal.get(0);
        DateTime lunesMedioDia = new DateTime(2016, 5, 23, 12, 0);
        Assert.assertTrue(cgp1.estaDisponible(lunesMedioDia));
    }
    
    @Test
    public void cGP1NoEstaDisponibleElLunesALas18() {
        PointOfInterest cgp1 = listaReal.get(0);
        DateTime lunesMedioDia = new DateTime(2016, 5, 23, 18, 0);
        Assert.assertFalse(cgp1.estaDisponible(lunesMedioDia));
    }
    
    @Test
    public void cGP2PalabraEstaPagos() {
        PointOfInterest cgp2 = listaReal.get(1);
        Assert.assertTrue(cgp2.palabraEsta("pagos"));
    }
}
