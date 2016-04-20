package testsEstaDisponible;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;

public class LocalComercialEstaDisponibleTest {
	private LocalComercial muebleriaDePepa;
	private Horario horario;
	private Point point;
	@Before
	public void init()
	{
		LocalTime horarioDeEntrada = LocalTime.of(8,0);
		LocalTime horarioDeSalida = LocalTime.of(17, 0);
		horario = new Horario();
		horario.agregarHorario(DayOfWeek.TUESDAY, horarioDeEntrada, horarioDeSalida);
		point = new Point(0, 0);
		muebleriaDePepa = new LocalComercial("muebleriaDePepa",point,Rubro.kiosco,horario);
	}
	@Test
	public void muebleriaDePepaAbiertoElMartesALas10()
	{
		LocalDateTime horario = LocalDateTime.of(2016, 4,19,10,0);
		Assert.assertTrue(muebleriaDePepa.estaDisponible(horario));
	}
	@Test
	public void muebleriaDePepaCerradoElMartesALas18()
	{
		LocalDateTime horario = LocalDateTime.of(2016, 4,19,18,0);
		Assert.assertFalse(muebleriaDePepa.estaDisponible(horario));
	}
}
