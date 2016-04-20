package testsModels;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ddsutn.group01.tpanual.models.Descripcion;

public class DescripcionTest {

	private Descripcion unaDescripcion;
	
	@Before
	public void init () {
		unaDescripcion = new Descripcion ();
		unaDescripcion.agregarDescripcion("114");
	}
	
	@Test
	public void DeberiaEstar114EnDescripcion (){
		Assert.assertTrue (unaDescripcion.buscarPalabra("114"));
	}
	
	@Test
	public void NoDeberiaEstar112EnDescripcion () {
		Assert.assertFalse (unaDescripcion.buscarPalabra("112"));
	}
}
