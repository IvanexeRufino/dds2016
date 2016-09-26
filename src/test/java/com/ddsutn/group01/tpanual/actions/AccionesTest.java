package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.roles.Terminal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

public class AccionesTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
    private Action mockedAction;
    private Terminal unaTerminal;
    private Buscador buscador = new Buscador();

    @Before
    public void setUp() throws Exception {
        unaTerminal = new Terminal("terminalUrquiza", 1, buscador);
        mockedAction = Mockito.mock(Action.class);

        unaTerminal.addAction(mockedAction);
    }

    @Test
    public void runsPrecondition() throws Exception {
        unaTerminal.find("foo");
        verify(mockedAction).precondition();
    }

    @Test
    public void runsPostcondition() throws Exception {
        unaTerminal.find("foo");
        verify(mockedAction).postcondition(any(String.class), anyListOf(PointOfInterest.class).size(), any(String.class));
    }
}