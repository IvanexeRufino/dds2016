package com.ddsutn.group01.tpanual;

import org.junit.Assert;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import com.ddsutn.group01.tpanual.repositories.actions.NotifyAdmin;


public class PersistentActionTest extends AbstractPersistenceTest implements WithGlobalEntityManager{
	
	@Test
	public void test() {
		NotifyAdmin na = new NotifyAdmin();
		na.setSecondsBeforeNotify(10);
		na.setTime(0);
		entityManager().persist(na);
		NotifyAdmin persistedna = entityManager().find(NotifyAdmin.class, na.getId());
		Assert.assertEquals(persistedna.getId(), na.getId());
	}

}
