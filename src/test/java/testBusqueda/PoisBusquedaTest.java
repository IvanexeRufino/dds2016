package testBusqueda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.PoiMaster;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

public class PoisBusquedaTest {
	
	private ParadaColectivo paradaDel7;
	private ParadaColectivo paradaDel114;
	private CentrosDeGestionYParticipacion cgpCaballito;
	private SucursalBanco bancoSantander;	
	private LocalComercial buffet;
	private LocalComercial libreriaDeJose;
	private LocalComercial muebleriaDePepa;
	private LocalComercial muebleriaDeJose;
	private PoiMaster grupoDePois;
	private List<PointOfInterest> lista;
	
	@Before
	public void init () {
		grupoDePois = new PoiMaster();
		
		lista = new ArrayList<>();
		
		HorariosDeAtencion horariosDeAtencion = new HorariosDeAtencion();
		
		Rubro muebleria = new Rubro ("Muebleria",0.4);
		Rubro libreriaEscolar= new Rubro("LibreriaEscolar",0.5);
		Rubro kiosco = new Rubro ("Kiosco",0.1);
		
		Servicio asesoramiento = new Servicio ("asesoramiento", horariosDeAtencion);
		
		Point point = new Point(0,0);
		Polygon polygon = new Polygon ();
	        polygon.add(new Point(-34.603689, -58.381652)); 
	        polygon.add(new Point(-34.601400, -58.381726)); 
	    
		
		muebleriaDePepa = new LocalComercial("Muebleria de Pepa", point, muebleria, horariosDeAtencion);
		
		muebleriaDeJose = new LocalComercial("Muebleria De Josefina",point,muebleria,horariosDeAtencion);
		
		libreriaDeJose = new LocalComercial("Libreria De Jose",point,libreriaEscolar,horariosDeAtencion);
		
		buffet = new LocalComercial("Albert Einstein",point,kiosco,horariosDeAtencion);
		buffet.agregarPalabraClave("utn");
		
		paradaDel7 = new ParadaColectivo ("7",point);
		paradaDel7.agregarPalabraClave("utn");
		
		paradaDel114 = new ParadaColectivo ("114",point);
		paradaDel114.agregarPalabraClave("utn");
		
		bancoSantander = new SucursalBanco ("banco santander", point);
		bancoSantander.agregarPalabraClave("cajero");
		bancoSantander.agregarPalabraClave("utn");
		
		cgpCaballito = new CentrosDeGestionYParticipacion ("cgp caballito",polygon);
		cgpCaballito.agregarUnServicio(asesoramiento);
		
		
			grupoDePois.agregarPoi(muebleriaDePepa);
        	grupoDePois.agregarPoi(muebleriaDeJose);
        	grupoDePois.agregarPoi(libreriaDeJose);
        	grupoDePois.agregarPoi(buffet);
        	grupoDePois.agregarPoi(paradaDel114);
        	grupoDePois.agregarPoi(paradaDel7);
        	grupoDePois.agregarPoi(bancoSantander);
        	grupoDePois.agregarPoi(cgpCaballito);
        	 	
    }	

	@Test
	public void buscoPorPalabraClaveCajeroDevuelveBanco () {
		lista.add(bancoSantander);
		Assert.assertEquals(grupoDePois.busquedaPoi("cajero"),lista);
		
	}
	
	@Test
	public void buscoPorPalabraClaveUtnDevuelveTodosPoisConPalabraClaveUtn () {
		lista.add(buffet);
		lista.add(paradaDel114);
		lista.add(paradaDel7);
		lista.add(bancoSantander);
		Assert.assertEquals(grupoDePois.busquedaPoi("utn"),lista);
		
	}
}
	

