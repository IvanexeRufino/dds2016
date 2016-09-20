package com.ddsutn.group01.tpanual;

import org.junit.Assert;

import org.junit.Test;

import com.ddsutn.group01.tpanual.repositories.actions.NotifyAdmin;


public class PersistentActionTest extends AbstractPersistenceTestTest{
	
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
