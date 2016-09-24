package com.ddsutn.group01.tpanual.roles;

import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.roles.Terminal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class TerminalTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    private Terminal terminal;
    private Buscador buscador;

    @Before
    public void setUp() {
        buscador = new Buscador();
        terminal = new Terminal("abasto", 1, buscador);

    }

    @Test
    public void terminalTest() {
        entityManager().persist(terminal);
        Terminal persistedTerminal = entityManager().find(Terminal.class, terminal.getId());
        Assert.assertEquals(persistedTerminal.getComuna(), 1);
        Assert.assertEquals(persistedTerminal.getNombreDeTerminal(), "abasto");
        Assert.assertEquals(persistedTerminal.getBuscador(), buscador);
    }
}
