package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import java.util.List;

public class FileitorTest {
    private Point point;
    private HorariosDeAtencion horarios;
    private Rubro rubro;
    private Fileitor fileitor;

    @Before
    public void init() {
        point = Mockito.mock(Point.class);
        horarios = Mockito.mock(HorariosDeAtencion.class);
        rubro = Rubro.kiosco;

        fileitor = new Fileitor("carrousel;barbie autos peluches\nkiosquito;chupelupe caramelos golosinas");
    }

    @Test
    public void testActualizarPalabrasClaves() {
        LocalComercial kioscoDeMario = new LocalComercial("kioscoDeMario", point, rubro, horarios);
        kioscoDeMario.agregarPalabraClave("foo");

        kioscoDeMario.actualizarPalabrasClaves("tita jorgito tictac");

        Assert.assertEquals(kioscoDeMario.getPalabrasClaves().size(), 3);
        Assert.assertFalse(kioscoDeMario.getPalabrasClaves().contains("foo"));
        Assert.assertTrue(kioscoDeMario.getPalabrasClaves().contains("tictac"));
        Assert.assertTrue(kioscoDeMario.getPalabrasClaves().contains("tita"));
        Assert.assertTrue(kioscoDeMario.getPalabrasClaves().contains("jorgito"));
    }

//	@Test
//	public void testBasicDisarm() {
//        LocalComercial carrousel = new LocalComercial("carrousel", point, rubro, horarios);
//        PoiRepository.getInstance().add(carrousel);
//
//		fileitor.basicDisarm("carrousel;juguete pelota barbie");
//		Assert.assertEquals(carrousel.getPalabrasClaves().size(), 3);
//	}

    @Test
    public void testDisarm() {
        List<String> result = fileitor.disarm();

        Assert.assertEquals(result.size(), 2);
        Assert.assertTrue(result.contains("carrousel;barbie autos peluches"));
    }
}
