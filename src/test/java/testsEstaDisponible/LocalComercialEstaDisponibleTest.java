package testsEstaDisponible;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import java.time.DayOfWeek;

public class LocalComercialEstaDisponibleTest {
	private LocalComercial muebleriaDePepa;

	@Before
	public void init() {
		LocalTime horaDeApertura = new LocalTime(8,0);
		LocalTime horaDeCierre = new LocalTime(17, 0);
		HorariosDeAtencion horariosDeAtencion = new HorariosDeAtencion();

		horariosDeAtencion.agregarHorario(DayOfWeek.TUESDAY, horaDeApertura, horaDeCierre);
		Rubro kiosco = Rubro.kiosco;
		Point point = new Point(0, 0);
		muebleriaDePepa = new LocalComercial("muebleria de Pepa", point, kiosco, horariosDeAtencion);
	}

	@Test
	public void muebleriaDePepaAbiertoElMartesALas10() {
		DateTime horario = new DateTime(2016, 4, 19, 10, 0);

		Assert.assertTrue(muebleriaDePepa.estaDisponible(horario));
	}

	@Test
	public void muebleriaDePepaCerradoElMartesALas18() {
		DateTime horario = new DateTime(2016, 4, 19, 18, 0);

		Assert.assertFalse(muebleriaDePepa.estaDisponible(horario));
	}
}
