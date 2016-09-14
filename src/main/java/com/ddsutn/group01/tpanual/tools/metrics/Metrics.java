package com.ddsutn.group01.tpanual.tools.metrics;

import com.ddsutn.group01.tpanual.repositories.actions.Action;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

@Entity
public class Metrics extends Action {
    private long timer;
    //lo mismo que en el resultado de las busquedas, no es necesario tener un array si la idea en un primer lugar fue almacenarlas

    @Override
    public void precondition() {
        timer = System.nanoTime();
    }

    @Override
    public void postcondition(String criteria, int result, String nombre) {
        timer = System.nanoTime() - timer;
        almacenar(criteria, result, timer);
    }

    private void almacenar(String criteria, int resultsCount, long timeLapsed) {
        EntityManager em = PerThreadEntityManagers.getEntityManager();
        em.persist(new MetricsSource(criteria, resultsCount, timeLapsed));
    }
}
