package com.ddsutn.group01.tpanual;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.repositories.Busqueda;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.actions.Action;
import com.ddsutn.group01.tpanual.tools.metrics.Metrics;
import com.ddsutn.group01.tpanual.tools.metrics.MetricsSource;

public class BusquedaTest extends AbstractPersistenceTest implements WithGlobalEntityManager{

	private Terminal terminal;
	private Buscador buscador;
	
    @Before
    public void setUp() {
    	buscador = new Buscador();
     	terminal = new Terminal("abasto", 1, buscador);
    }
    
    @Test
    public void busquedaTestGuardaResultadosDeLaBusqueda() throws InterruptedException {
    	Point point = new Point(4,5);
    	ParadaColectivo parada = new ParadaColectivo("114", point);
    	PoiRepository.getInstance().add(parada);
    	terminal.find("114");
		Busqueda persistedBusqueda = (Busqueda) entityManager().createQuery("from Busqueda").getSingleResult();
    	Assert.assertEquals(persistedBusqueda.getCriteria() , "114");
    }

    @Test
    public void busquedaMasMetricsParaIntegrar(){
    	Point point = new Point(4,5);
    	ParadaColectivo parada = new ParadaColectivo("116", point);
    	PoiRepository.getInstance().add(parada);
    	Metrics metrica = new Metrics();
    	List<Action> acciones = new ArrayList<>();
    	acciones.add(metrica);
    	terminal.setActions(acciones);
    	terminal.find("116");
		Busqueda persistedBusqueda = (Busqueda) entityManager().createQuery("from Busqueda").getSingleResult();
		MetricsSource persistedMetricSource = (MetricsSource) entityManager().createQuery("from MetricsSource").getSingleResult();
    	Assert.assertEquals(persistedBusqueda.getCriteria() , "116");
		Assert.assertEquals(persistedMetricSource.getResultados(), 1);
    }

}
