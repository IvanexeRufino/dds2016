package testBusqueda;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Polygon;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.PoiMaster;

public class CGPBusquedaTest {
    private CentrosDeGestionYParticipacion CGP1;
    private CentrosDeGestionYParticipacion CGP2;
    private CentrosDeGestionYParticipacion CGP3;
    private HorariosDeAtencion horario;
    private Servicio rRHH;
    private Servicio asesoramientoLegal;
    private Servicio asesoramientoFinanciero;
	private List<CentrosDeGestionYParticipacion> lista;
	private PoiMaster grupoDePois;
    
	@Before
	public void init()
	{
		grupoDePois = new PoiMaster();
		lista = new ArrayList<>();
        Polygon polygon = new Polygon();
        horario= new HorariosDeAtencion();
        CGP1 = new CentrosDeGestionYParticipacion("fou", polygon);
        CGP2 = new CentrosDeGestionYParticipacion("foi", polygon);
        CGP3 = new CentrosDeGestionYParticipacion("foo", polygon);
        rRHH = new Servicio("Recursos Humanos", horario);
        asesoramientoLegal = new Servicio("Asesoramiento Legal", horario);
        asesoramientoFinanciero = new Servicio("Asesoramiento Financiero",horario);
        CGP1.agregarUnServicio(rRHH);
        CGP2.agregarUnServicio(asesoramientoLegal);
        CGP3.agregarUnServicio(asesoramientoFinanciero);
        grupoDePois.agregarPoi(CGP1);
        grupoDePois.agregarPoi(CGP2);
        grupoDePois.agregarPoi(CGP3);
	}
	@Test
	public void BuscarAsesoramientoDevuelveListaConCGPSConAsesoramientos()
	{
		lista.add(CGP2);
		lista.add(CGP3);
		Assert.assertEquals(lista,grupoDePois.busquedaPoi("Asesoramiento"));
	}
	@Test
	public void BuscarAsesoramientoLegalDevuelveListaConCGPConServicioDeAsesoramientoLegal()
	{
		lista.add(CGP2);
		Assert.assertEquals(lista, grupoDePois.busquedaPoi("Asesoramiento Legal"));
	}
}
