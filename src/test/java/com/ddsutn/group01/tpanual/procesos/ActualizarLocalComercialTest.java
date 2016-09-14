package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;


public class ActualizarLocalComercialTest {
    private Point point;
    private HorariosDeAtencion horarios;
    private Rubro rubro;


	@Before
    public void init() {
        point = Mockito.mock(Point.class);
        horarios = Mockito.mock(HorariosDeAtencion.class);
        rubro = Rubro.kiosco;
	}

	@Test
	public void testActualizarPalabrasClaves() {
        LocalComercial carrousel = new LocalComercial("carrousel", point, rubro, horarios);
        carrousel.agregarPalabraClave("colegio");

		carrousel.actualizarPalabrasClaves("chocolate caramelos chupelupe");

		Assert.assertEquals(carrousel.getPalabrasClaves().size(), 3);
		Assert.assertTrue(carrousel.getPalabrasClaves().contains("chocolate"));
		Assert.assertTrue(carrousel.getPalabrasClaves().contains("caramelos"));
		Assert.assertTrue(carrousel.getPalabrasClaves().contains("chupelupe"));
	}

//	@Test
//	public void testEjecutarActualizacionLocalComercial() {}

}
