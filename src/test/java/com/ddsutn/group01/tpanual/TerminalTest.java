package com.ddsutn.group01.tpanual;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.repositories.Buscador;

public class TerminalTest extends AbstractPersistenceTestTest{
	
	private Terminal terminal;
	private Buscador buscador;
	
    @Before
    public void setUp() {
    	 buscador = new Buscador();
     	terminal = new Terminal("abasto", 1, buscador);

    }
    
    @Test
    public void terminalTest() {
    	em.persist(terminal);
    	Terminal persistedTerminal = em.find(Terminal.class, terminal.getId());
    	Assert.assertEquals(persistedTerminal.getComuna(), 1);
    	Assert.assertEquals(persistedTerminal.getNombreDeTerminal(), "abasto");
    	Assert.assertEquals(persistedTerminal.getBuscador(), buscador);
    }
}
