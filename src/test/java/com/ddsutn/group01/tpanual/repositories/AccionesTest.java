package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.actions.Action;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AccionesTest {
    private Action mockedAction;
    private Terminal unaTerminal;
    private Buscador buscador = new Buscador();
	EntityManager entityManager;
    EntityTransaction tx;;


    @Before
    public void setUp() throws Exception {
        unaTerminal = new Terminal("terminalUrquiza", 1, buscador);
        mockedAction = Mockito.spy(new Action() {
            @Override
            public void precondition() {}

            @Override
            public void postcondition(String criteria, int result, String nombre) {}
        });

        unaTerminal.addAction(mockedAction);
        entityManager = PerThreadEntityManagers.getEntityManager();
        tx = entityManager.getTransaction();
    }

    @Test
    public void runsPrecondition() throws Exception {
    	tx.begin();
        unaTerminal.find("foo");
        verify(mockedAction).precondition();
        tx.rollback();
    }

    @Test
    public void runsPostcondition() throws Exception {
    	tx.begin();
        unaTerminal.find("foo");
        verify(mockedAction).postcondition(any(String.class), anyListOf(PointOfInterest.class).size(),any(String.class));
        tx.rollback();
    }
}
