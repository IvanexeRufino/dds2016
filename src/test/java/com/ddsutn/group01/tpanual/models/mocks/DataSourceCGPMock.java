package com.ddsutn.group01.tpanual.models.mocks;

import java.util.ArrayList;


import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;
import com.ddsutn.group01.tpanual.adapters.CGP.ServicioDTO;
import com.ddsutn.group01.tpanual.dataSources.DataSourceCGP;


public class DataSourceCGPMock implements DataSourceCGP {
	@Override
	public ArrayList<CentroDTO> search(String criteria) {
		ArrayList<ServicioDTO> servicios = new ArrayList<ServicioDTO>();
		ArrayList<String> zonas = new ArrayList<String>();
		zonas.add("caballito");
		CentroDTO unCentroDTO = new CentroDTO(2, zonas, "juancho perez", "rivadavia 4450", "45682315", servicios);

		ArrayList<CentroDTO> resultados = new ArrayList<CentroDTO>();
		resultados.add(unCentroDTO);

		return resultados;
	}
}
