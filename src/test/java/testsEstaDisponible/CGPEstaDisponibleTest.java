package testsEstaDisponible;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;

public class CGPEstaDisponibleTest {
	
    private CentrosDeGestionYParticipacion CGP;
    private Horario horarioDeRRHH;
    private Horario horarioDeAsesoramientoLegal;
    private Servicio rRHH;
    private Servicio asesoramientoLegal;
	@Before
	public void init()
	{
        Polygon polygon = new Polygon();
        polygon.add(new Point(-34.603689, -58.381652));
        polygon.add(new Point(-34.601400, -58.381726));
        polygon.add(new Point(-34.602442, -58.379577));
        LocalTime horarioDeEntrada = LocalTime.of(8,00);
        LocalTime horarioDeSalida = LocalTime.of(18,00);
        horarioDeRRHH = new Horario();
        horarioDeAsesoramientoLegal = new Horario();
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
		LocalDateTime horario = LocalDateTime.of(2016,4,19,12,0);
		Assert.assertTrue(CGP.estaDisponible("asesoramientoLegal",horario));
	}
	@Test
	public void asesoramientoNoEstaDisponibleElLunesALas10()
	{
		LocalDateTime horario = LocalDateTime.of(2016, 4,18,10,0);
		Assert.assertFalse(CGP.estaDisponible("asesoramientoLegal",horario));
	}
}
