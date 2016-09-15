package com.ddsutn.group01.tpanual;


import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import com.ddsutn.group01.tpanual.repositories.actions.NotifyAdmin;


public class PersistentActionTest {
	private EntityManager em;

	@Before
	public void setUp(){
		em = PerThreadEntityManagers.getEntityManager();
	}
	@Test
	public void test() {
		NotifyAdmin na = new NotifyAdmin();
		na.setSecondsBeforeNotify(10);
		na.setTime(0);
		em.persist(na);
		NotifyAdmin persistedna = em.find(NotifyAdmin.class, na.getId());
		Assert.assertEquals(persistedna.getId(), na.getId());
		
	}

}
