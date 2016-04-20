package testsEstaDisponible;

import java.time.DayOfWeek;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;

public class CGPEstaDisponibleTest {

    private CentrosDeGestionYParticipacion CGP;
    private HorariosDeAtencion horarioDeRRHH;
    private HorariosDeAtencion horarioDeAsesoramientoLegal;
    private Servicio rRHH;
    private Servicio asesoramientoLegal;
	@Before
	public void init()
	{
        Polygon polygon = new Polygon();
        polygon.add(new Point(-34.603689, -58.381652));
        polygon.add(new Point(-34.601400, -58.381726));
        polygon.add(new Point(-34.602442, -58.379577));
        LocalTime horarioDeEntrada= new LocalTime(9, 00);
        LocalTime horarioDeSalida = new LocalTime(18,00);
        horarioDeRRHH = new HorariosDeAtencion();
        horarioDeAsesoramientoLegal = new HorariosDeAtencion();
        horarioDeRRHH.agregarHorario(DayOfWeek.MONDAY,horarioDeEntrada,horarioDeSalida);
        horarioDeAsesoramientoLegal.agregarHorario(DayOfWeek.TUESDAY, horarioDeEntrada, horarioDeSalida);
        CGP = new CentrosDeGestionYParticipacion("foo", polygon);
        rRHH = new Servicio("RRHH", horarioDeRRHH);
        asesoramientoLegal = new Servicio("asesoramientoLegal", horarioDeAsesoramientoLegal);
        CGP.agregarUnServicio(rRHH);
        CGP.agregarUnServicio(asesoramientoLegal);
	}
	@Test
	public void asesoramientoEstaDisponibleElMartesALas12()
	{
		DateTime horario = new DateTime(2016, 4, 19, 12, 00);
		Assert.assertTrue(CGP.estaDisponible("asesoramientoLegal",horario));
	}
	@Test
	public void asesoramientoNoEstaDisponibleElLunesALas10()
	{
		DateTime horario = new DateTime(2016, 4, 18, 10, 00);
		Assert.assertFalse(CGP.estaDisponible("asesoramientoLegal",horario));
	}
	@Test
	public void rRHHEstaDisponibleElLunesALas10()
	{
		DateTime horario = new DateTime(2016, 4, 18, 10, 00);
		Assert.assertTrue(CGP.estaDisponible("RRHH",horario));
	}
	@Test
	public void hayAlmenosUnServicioDisponibleElMartesALas17()
	{
		DateTime horario = new DateTime(2016, 4, 19, 17, 00);
		Assert.assertTrue(CGP.estaDisponible(horario));
	}
	@Test
	public void noHayNingunServicioDisponibleElMiercolesALas12()
	{
		DateTime horario = new DateTime(2016, 4, 20, 12, 00);
		Assert.assertFalse(CGP.estaDisponible(horario));
	}
}
