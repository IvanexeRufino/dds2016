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



public class ActualizarLocalComercialTest {
	private LocalOrigin olocal;
	private LocalComercial carrousel;
    private Point point;
    private HorariosDeAtencion horariosDeAtencion;
    private Rubro rubro;
	
	
	@Before
	public void init() {
	LocalOrigin olocal = new LocalOrigin();
	
	Point point = new Point(1,1);
    HorariosDeAtencion horarios = new HorariosDeAtencion();
    Rubro rubro = Rubro.kiosco;

    LocalComercial carrousel = new LocalComercial(1,"carrousel",point,rubro,horarios);
	carrousel.agregarPalabraClave("hola");
	
    olocal.add(carrousel);
   
	}

	@Test
	public void testActualizarPalabrasClaves() {		
		//carrousel.actualizarPalabrasClaves("juguete pelota");
		Assert.assertTrue((carrousel.getPalabrasClaves().size())== 1);
	}

}
