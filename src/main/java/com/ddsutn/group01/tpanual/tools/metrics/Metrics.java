package com.ddsutn.group01.tpanual.tools.metrics;

import com.ddsutn.group01.tpanual.repositories.actions.Action;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

@Entity
public class Metrics extends Action {
	@Transient
    private long timer;

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
