package testsEstaDisponible;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class SucursalBancoEstaDisponibleTest {
    private SucursalBanco bancoSantander;

    @Before
    public void init() {
		Point point = new Point(-34.603689, -58.381652); // https://goo.gl/maps/NquccBrGJsz
        bancoSantander = new SucursalBanco("santander", point);
    }

	@Test
	public void BancoEstaDiponibleTest() {
		DateTime horario = new DateTime(2016, 4, 20, 12, 00);
		Assert.assertTrue(bancoSantander.estaDisponible("atencion al cliente", horario));
	}

	@Test
	public void BancoNoEstaDiponibleTest() {
		DateTime horario = new DateTime(2016, 4, 20, 23, 00);
		Assert.assertFalse(bancoSantander.estaDisponible("atencion al cliente", horario));
	}
	
	@Test
	public void BancoConServicioQueNoTieneNoDeberiaEstarDisponibleTest() {
		DateTime horario = new DateTime(2016, 4, 20, 23, 00);
		Assert.assertFalse(bancoSantander.estaDisponible("cobros", horario));
	}
}
