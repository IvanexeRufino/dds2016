package testBusqueda;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.PoiMaster;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Polygon;

import java.util.ArrayList;
import java.util.List;

public class CGPBusquedaTest {
    private CentrosDeGestionYParticipacion CGP2;
    private CentrosDeGestionYParticipacion CGP3;
	private List<CentrosDeGestionYParticipacion> lista;
	private PoiMaster grupoDePois;

	@Before
	public void init()
	{
		grupoDePois = new PoiMaster();
		lista = new ArrayList<>();
        Polygon polygon = new Polygon();
        HorariosDeAtencion horario= new HorariosDeAtencion();
        CentrosDeGestionYParticipacion CGP1 = new CentrosDeGestionYParticipacion("fou", polygon);
        CGP2 = new CentrosDeGestionYParticipacion("foi", polygon);
        CGP3 = new CentrosDeGestionYParticipacion("foo", polygon);
        Servicio rRHH = new Servicio("Recursos Humanos", horario);
        Servicio asesoramientoLegal = new Servicio("Asesoramiento Legal", horario);
        Servicio asesoramientoFinanciero = new Servicio("Asesoramiento Financiero",horario);
        CGP1.agregarUnServicio(rRHH);
        CGP2.agregarUnServicio(asesoramientoLegal);
        CGP3.agregarUnServicio(asesoramientoFinanciero);
        grupoDePois.agregarPoi(CGP1);
        grupoDePois.agregarPoi(CGP2);
        grupoDePois.agregarPoi(CGP3);
	}
	@Test
	public void BuscarAsesoramientoDevuelveListaConCGPSConAsesoramientos() {
		lista.add(CGP2);
		lista.add(CGP3);
		Assert.assertEquals(lista,grupoDePois.busquedaPoi("Asesoramiento"));
	}

	@Test
	public void BuscarAsesoramientoLegalDevuelveListaConCGPConServicioDeAsesoramientoLegal() {
		lista.add(CGP2);
		Assert.assertEquals(lista, grupoDePois.busquedaPoi("Asesoramiento Legal"));
	}
}
