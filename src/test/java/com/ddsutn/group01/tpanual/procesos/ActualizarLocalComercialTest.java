package com.ddsutn.group01.tpanual.procesos;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.origins.LocalOrigin;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;



public class ActualizarLocalComercialTest {
	private LocalComercial carrousel;
    private Point point;
    private HorariosDeAtencion horarios;
    private Rubro rubro;
	
	
	@Before
	public void init() {
	PoiRepository repo = PoiRepository.getInstance();
	
	point = new Point(1,1);
    horarios = new HorariosDeAtencion();
    rubro = Rubro.kiosco;

    carrousel = new LocalComercial(1,"carrousel",point,rubro,horarios);
	carrousel.agregarPalabraClave("hola");
   
	}

	@Test
	public void testActualizarPalabrasClaves() {		
		//carrousel.actualizarPalabrasClaves("juguete pelota");
		Assert.assertEquals(carrousel.getPalabrasClaves().size(), 1);
	}

}
