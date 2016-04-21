package testBusqueda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.PoiMaster;


public class LocalComercialBusquedaTest {
	private LocalComercial muebleriaDePepa;
	private LocalComercial libreriaDeJose;
	private LocalComercial muebleriaDeJosefina;
	private List<LocalComercial> lista;
	private PoiMaster grupoDePois;
	@Before
	public void init()
	{	
		grupoDePois = new PoiMaster();
		lista = new ArrayList<>();
		HorariosDeAtencion horariosDeAtencion = new HorariosDeAtencion();
		Rubro muebleria = new Rubro ("Muebleria",0.4);
		Rubro libreriaEscolar= new Rubro("LibreriaEscolar",0.5);
		Point point = new Point(0, 0);
		Point point2 = new Point(1,0);
		muebleriaDePepa = new LocalComercial("Muebleria de Pepa", point, muebleria, horariosDeAtencion);
		muebleriaDeJosefina = new LocalComercial("Muebleria De Josefina",point,muebleria,horariosDeAtencion);
		libreriaDeJose = new LocalComercial("Libreria De Jose",point2,libreriaEscolar,horariosDeAtencion);
		grupoDePois.agregarPoi(muebleriaDePepa);
        grupoDePois.agregarPoi(muebleriaDeJosefina);
        grupoDePois.agregarPoi(libreriaDeJose);
	}
	@Test
	public void BuscarMuebleriaDevuelveListaConLaDePepaYlaDeJosefina()
	{
		lista.add(muebleriaDePepa);
		lista.add(muebleriaDeJosefina);
		Assert.assertEquals(grupoDePois.busquedaPoi("Muebleria"),lista);
	}
	@Test
	public void BuscarLibreriaEscolarDevuelveListaConLibreriaDeJoseNomas()
	{	
		lista.add(libreriaDeJose);
		Assert.assertEquals(lista,grupoDePois.busquedaPoi("LibreriaEscolar"));
	}
}
