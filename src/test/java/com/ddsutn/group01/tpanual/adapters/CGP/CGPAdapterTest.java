package com.ddsutn.group01.tpanual.adapters.CGP;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CGPAdapterTest {
    @Test
    public void adapt() throws Exception {
        ArrayList<CentroDTO> unaListaDeCentrosDTO = new ArrayList<>();

        ArrayList<String> zonasIncluidas = new ArrayList<>();
        zonasIncluidas.add("palermo");
        zonasIncluidas.add("belgrano");

        ArrayList<DiasDeServicio> unosDias = new ArrayList<>();

        ServicioDTO pagos = new ServicioDTO("pagos", unosDias);
        ServicioDTO cobros = new ServicioDTO("cobros", unosDias);

        ArrayList<ServicioDTO> servicios = new ArrayList<>();
        servicios.add(cobros);
        servicios.add(pagos);

        CentroDTO unCentroDTO = new CentroDTO(4, zonasIncluidas, "pepito", "junin 45", "45698541", servicios);
        CentroDTO otroCentroDTO = new CentroDTO(1, zonasIncluidas, "juana", "rosario 27", "89652145", servicios);

        unaListaDeCentrosDTO.add(unCentroDTO);
        unaListaDeCentrosDTO.add(otroCentroDTO);

        List<PointOfInterest> listaReal = CGPAdapter.adapt(unaListaDeCentrosDTO);

        Assert.assertTrue(listaReal.size() == 2);
    }

}
