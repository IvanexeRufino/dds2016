package com.ddsutn.group01.tpanual;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
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

public class TerminalTest {
	
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
    public void terminalTest() {
    	tx = entityManager.getTransaction();
    	tx.begin();
    	entityManager.persist(buscador);
    	entityManager.persist(terminal);
    	entityManager.flush();
    	tx.commit();
    	
    	Terminal persistedTerminal = entityManager.find(Terminal.class, 2);
    	Buscador persistedBuscador = entityManager.find(Buscador.class, 1);
    	Assert.assertEquals(persistedTerminal.getComuna(), 1);
    	Assert.assertEquals(persistedTerminal.getNombreDeTerminal(), "abasto");
    	Assert.assertEquals(persistedTerminal.getBuscador(), buscador);
    }
}
