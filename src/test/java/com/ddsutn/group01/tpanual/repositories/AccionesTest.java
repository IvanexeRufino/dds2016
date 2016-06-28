package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.actions.Action;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

public class AccionesTest {
    private Action mockedAction;
    private Buscador buscador = new Buscador();
    private Terminal unaTerminal = new Terminal("terminalUrquiza",1);

    @Before
    public void setUp() throws Exception {
        mockedAction = Mockito.spy(new Action() {
            @Override
            public void precondition() {}

            @Override
            public void postcondition(String criteria, List<PointOfInterest> result) {}
        });
        unaTerminal.setBuscador(buscador);
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
        verify(mockedAction).postcondition(any(String.class), anyListOf(PointOfInterest.class));
    }
}
