package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.tools.metrics.SearchMetrics;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

@Entity
public class ActionWithSearchMetrics extends Action {

    @Transient
    private long timer;

    @Override
    public void precondition() {
        timer = System.nanoTime();
    }

    @Override
    public void postcondition(String searchText, int resultsCount, String nombreDeTerminal) {
        long timeLapsed = System.nanoTime() - timer;

        EntityManager em = PerThreadEntityManagers.getEntityManager();
        em.persist(new SearchMetrics(searchText, resultsCount, timeLapsed));
    }

}
