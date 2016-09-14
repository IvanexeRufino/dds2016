package com.ddsutn.group01.tpanual;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.tools.metrics.Metrics;
import com.ddsutn.group01.tpanual.tools.metrics.MetricsSource;

public class PersistentMetricTest {

	private Metrics metrica;
	private EntityManager entityManager;
	private EntityTransaction tx;
	
	@Before
	public void setUp() {
		metrica = new Metrics();
		entityManager = PerThreadEntityManagers.getEntityManager();
	}
	
	@Test
	public void metricsPersist() {
		metrica.postcondition("algo", 1, "algo");
		MetricsSource data = entityManager.find(MetricsSource.class, 1);
		Assert.assertEquals(data.getResultados(), 1);
	}
}
