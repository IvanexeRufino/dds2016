package com.ddsutn.group01.tpanual.models;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.ddsutn.group01.tpanual.models.CgpDTO.CentroDTO;
import com.ddsutn.group01.tpanual.models.CgpDTO.CgpAdapter;
import com.ddsutn.group01.tpanual.models.CgpDTO.DiasDeServicio;
import com.ddsutn.group01.tpanual.models.CgpDTO.ServicioDTO;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

public class TestAdapterCgp {

	private CgpAdapter adapter = new CgpAdapter();

	@Test
	public void testAdaptarListaCentroDTOaListaDeCgp() {
		ArrayList<CentroDTO> unaListaDeCentrosDTO = new ArrayList<>();

		ArrayList<String> zonasIncluidas = new ArrayList<>();
		zonasIncluidas.add("palermo");
		zonasIncluidas.add("belgrano");

		ArrayList<DiasDeServicio> unosDias = new ArrayList<>();

		ServicioDTO pagos = new ServicioDTO ("pagos", unosDias);
		ServicioDTO cobros = new ServicioDTO ("cobros", unosDias);

		ArrayList <ServicioDTO> servicios = new ArrayList <>();
		servicios.add(cobros);
		servicios.add(pagos);

		CentroDTO unCentroDTO = new CentroDTO (4, zonasIncluidas, "pepito", "junin 45", "45698541", servicios);
		CentroDTO otroCentroDTO = new CentroDTO (1, zonasIncluidas, "juana","rosario 27", "89652145", servicios);

		unaListaDeCentrosDTO.add(unCentroDTO);
		unaListaDeCentrosDTO.add(otroCentroDTO);

		ArrayList<PointOfInterest> listaReal = adapter.parsear(unaListaDeCentrosDTO);

		Assert.assertTrue(listaReal.size()==2);
	}
}
