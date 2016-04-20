package testsModels;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;


import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.PoiMaster;

public class PoiMasterTest {
	
	private ParadaColectivo paradaUno;
	private ParadaColectivo paradaDos;
	private ParadaColectivo paradaTres;
	private PoiMaster poiMaster;
	
	@Before 
	public void init () {
		
		Point pointParadaUno = new Point(-34.603689, -58.381652);
		Point pointParadaDos = new Point(-34.603660, -58.381650);
		Point pointParadaTres = new Point(-34.603600,-58.381630);
						
		paradaUno = new ParadaColectivo ("paradaDeColectivo114",pointParadaUno);
		paradaUno.agregarDescripcion("114");
		
		paradaDos = new ParadaColectivo ("paradaDeColectivo114",pointParadaDos);
		paradaDos.agregarDescripcion("114");
		
		paradaTres = new ParadaColectivo ("paradaDeColectivo114",pointParadaTres);
		paradaTres.agregarDescripcion("114");
		
		poiMaster = new PoiMaster();
		poiMaster.agregarPoi(paradaUno);
		poiMaster.agregarPoi(paradaDos);
		poiMaster.agregarPoi(paradaTres);

		
	}
	
	@Test
	public void busquedaParadas114() {
		Assert.assertTrue(poiMaster.busquedaPoi("114").count() == 3);
		
	}

}
