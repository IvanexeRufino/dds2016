package com.ddsutn.group01.tpanual.models.mocks;

import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;
import com.ddsutn.group01.tpanual.adapters.CGP.ServicioDTO;
import com.ddsutn.group01.tpanual.dataSources.DataSourceCGP;

import java.util.ArrayList;


public class DataSourceCGPMock implements DataSourceCGP {
    @Override
    public ArrayList<CentroDTO> search(String criteria) {
        ArrayList<ServicioDTO> servicios = new ArrayList<>();
        ArrayList<String> zonas = new ArrayList<>();
        zonas.add("caballito");
        CentroDTO unCentroDTO = new CentroDTO(2, zonas, "juancho perez", "rivadavia 4450", "45682315", servicios);

        ArrayList<CentroDTO> resultados = new ArrayList<>();
        resultados.add(unCentroDTO);

        return resultados;
    }
}
