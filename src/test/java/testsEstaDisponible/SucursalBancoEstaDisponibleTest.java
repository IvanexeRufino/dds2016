package testsEstaDisponible;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

public class SucursalBancoEstaDisponibleTest {
	
    private Point point;
    SucursalBanco santander; 
    
    @Before
    public void init() {
        point = new Point(-34.603689, -58.381652); // https://goo.gl/maps/NquccBrGJsz
        santander = new SucursalBanco("santander",point);   
        santander.agregarUnServicio("atencion al cliente");
    }	 

	@Test
	public void BancoEstaDiponibleTest() {
		LocalDateTime unaFecha = LocalDateTime.of(2016, 4, 20, 12, 00, 00);
		Assert.assertTrue (santander.estaDisponible("atencion al cliente", unaFecha));
		
	}
	
	@Test
	public void BancoNoEstaDiponibleTest() {
		LocalDateTime unaFecha = LocalDateTime.of(2016, 4, 20, 23, 00, 00);
		Assert.assertFalse (santander.estaDisponible("atencion al cliente", unaFecha));
		
	}
	
	

}
