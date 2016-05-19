package com.ddsutn.group01.tpanual.models;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.ddsutn.group01.tpanual.models.CgpDTO.CentroDTO;
import com.ddsutn.group01.tpanual.models.CgpDTO.CgpAdapter;
import com.ddsutn.group01.tpanual.models.CgpDTO.DiasDeServicio;
import com.ddsutn.group01.tpanual.models.CgpDTO.ServicioDTO;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;

public class TestAdapterCgp {
	
	private CgpAdapter adapter = new CgpAdapter();

	@Test
	public void testAdaptarListaCentroDTOaListaDeCgp() {
		ArrayList<CentroDTO> unaListaDeCentrosDTO = new ArrayList<CentroDTO>();
		
		ArrayList<String> zonasIncluidas = new ArrayList<String>();
		zonasIncluidas.add("palermo");
		zonasIncluidas.add("las cañitas");
		
		ArrayList<DiasDeServicio> unosDias = new ArrayList<DiasDeServicio>();
		
		ServicioDTO pagos = new ServicioDTO ("pagos",unosDias);
		ServicioDTO cobros = new ServicioDTO ("cobros",unosDias);
		
		ArrayList <ServicioDTO> servicios = new ArrayList <ServicioDTO>();	
		servicios.add(cobros);
		servicios.add(pagos);		
		
		CentroDTO unCentroDTO = new CentroDTO (4,zonasIncluidas,"pepito", "junin 45", "45698541",servicios);
		CentroDTO otroCentroDTO = new CentroDTO (1,zonasIncluidas,"juana","rosario 27","89652145", servicios);
		
		unaListaDeCentrosDTO.add(unCentroDTO);
		unaListaDeCentrosDTO.add(otroCentroDTO);
		
		ArrayList<CentrosDeGestionYParticipacion> listaReal = adapter.adaptar(unaListaDeCentrosDTO);
		
		Assert.assertTrue(listaReal.size()==2);
	}

}
