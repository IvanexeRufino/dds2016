package com.ddsutn.group01.tpanual;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.repositories.Buscador;

public class TerminalTest {
	
	private Terminal terminal;
	private Buscador buscador;
	private EntityManager entityManager;
	
    @Before
    public void setUp() {
    	entityManager = PerThreadEntityManagers.getEntityManager();
    	 buscador = new Buscador();
     	terminal = new Terminal("abasto", 1, buscador);
    }
    
    @Test
    public void terminalTest() {
    	entityManager.persist(buscador);
    	entityManager.persist(terminal);
    	Terminal persistedTerminal = entityManager.find(Terminal.class, terminal.getId());
    	Assert.assertEquals(persistedTerminal.getComuna(), 1);
    	Assert.assertEquals(persistedTerminal.getNombreDeTerminal(), "abasto");
    	Assert.assertEquals(persistedTerminal.getBuscador(), buscador);
    }
}
