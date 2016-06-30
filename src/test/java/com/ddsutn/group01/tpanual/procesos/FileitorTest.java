package com.ddsutn.group01.tpanual.procesos;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.Procesos.Fileitor;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class FileitorTest {
	private LocalComercial carrousel;
	private LocalComercial kiosquito;
	private LocalComercial kioscoDeMario;
    private Point point;
    private HorariosDeAtencion horarios;
    private Rubro rubro;
    private Fileitor fileitor;
    	
	@Before
	public void init() {	
	point = new Point(1,1);
    horarios = new HorariosDeAtencion();
    rubro = Rubro.kiosco;

    carrousel = new LocalComercial(1,"carrousel",point,rubro,horarios);
	carrousel.agregarPalabraClave("autos");
	
	kiosquito = new LocalComercial (2,"kiosquito",point,rubro,horarios);
	kiosquito.agregarPalabraClave("chupelupe");
	
	kioscoDeMario = new LocalComercial (2,"kioscoDeMario",point,rubro,horarios);
	kioscoDeMario.agregarPalabraClave("tita");
	
	PoiRepository.getInstance().add(carrousel);
	PoiRepository.getInstance().add(kiosquito);
	PoiRepository.getInstance().add(kioscoDeMario);
	
	fileitor = new Fileitor ("carrousel;barbie autos peluches /n kiosquito;chupelupe caramelos golosinas");
	
	}

	@Test
	public void testActualizarPalabrasClaves() {
		kioscoDeMario.actualizarPalabrasClaves("tita jorgito tictac");
		Assert.assertEquals(kioscoDeMario.getPalabrasClaves().size(), 3);
		Assert.assertTrue(kioscoDeMario.getPalabrasClaves().contains("tictac"));
		Assert.assertTrue(kioscoDeMario.getPalabrasClaves().contains("tita"));
		Assert.assertTrue(kioscoDeMario.getPalabrasClaves().contains("jorgito"));
	}
	
	@Test
	public void testBasicDisarm() {
		fileitor.basicDisarm("carrousel;juguete pelota");
		Assert.assertEquals(carrousel.getPalabrasClaves().size(), 2);		
	}	
}