package testBusqueda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.PoiMaster;


public class ParadaDeColectivoBusquedaTest {
	private ParadaColectivo poi;
	private ParadaColectivo poi2;
	private PoiMaster grupoDePois;
	private List<ParadaColectivo> lista;
	
	 @Before
	    public void init() {
		 	lista = new ArrayList<>();
		 	grupoDePois = new PoiMaster();
	        Point point1 = new Point(0, 0);
	        Point point2 = new Point(1, 0);
	        poi = new ParadaColectivo("114", point1);
	        poi2 = new ParadaColectivo("7",point2);
	        grupoDePois.agregarPoi(poi);
	        grupoDePois.agregarPoi(poi2);
	    }
	 @Test
	 public void Buscar114DevuelveUnaListaConLaParadaDe114Nomas()
	 {
		 lista.add(poi);
		 Assert.assertEquals(grupoDePois.busquedaPoi("114"),lista);
	 }
	 @Test
	 public void Buscar8DevuelveListaVacia()
	 {
		 Assert.assertEquals(grupoDePois.busquedaPoi("8"), lista);
	 }
}