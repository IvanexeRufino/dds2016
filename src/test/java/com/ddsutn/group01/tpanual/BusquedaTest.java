package com.ddsutn.group01.tpanual;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.repositories.Busqueda;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.actions.Action;
import com.ddsutn.group01.tpanual.tools.metrics.Metrics;
import com.ddsutn.group01.tpanual.tools.metrics.MetricsSource;

public class BusquedaTest {

	private Terminal terminal;
	private Buscador buscador;
	private EntityManager entityManager;
	private EntityTransaction tx;
	
    @Before
    public void setUp() {
    	entityManager = PerThreadEntityManagers.getEntityManager();
    	buscador = new Buscador();
     	terminal = new Terminal("abasto", 1, buscador);
    }
	
    @Test
    public void busquedaTestGuardaResultadosDeLaBusqueda() {
    	Point point = new Point(4,5);
    	ParadaColectivo parada = new ParadaColectivo("114", point);
    	PoiRepository.getInstance().add(parada);
    	terminal.find("114");
    	Busqueda persistedBusqueda = entityManager.find(Busqueda.class, 2);
    	Assert.assertEquals(persistedBusqueda.getCriteria() , "114");
    }
    
    @Test
    public void busquedaMasMetricsParaIntegrar(){
    	Point point = new Point(4,5);
    	ParadaColectivo parada = new ParadaColectivo("114", point);
    	PoiRepository.getInstance().add(parada);
    	Metrics metrica = new Metrics();
    	List<Action> acciones = new ArrayList<Action>();
    	acciones.add(metrica);
    	terminal.setActions(acciones);
    	terminal.find("114");
    	Busqueda persistedBusqueda = entityManager.find(Busqueda.class, 2);
    	MetricsSource data = entityManager.find(MetricsSource.class, 3);
    	Assert.assertEquals(persistedBusqueda.getCriteria() , "114");
		Assert.assertEquals(data.getResultados(), 1);
    }
}
