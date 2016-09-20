package com.ddsutn.group01.tpanual;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class AbstractPersistenceTestTest extends AbstractPersistenceTest{
	
	protected EntityManager em = PerThreadEntityManagers.getEntityManager();
	
	@Test
	public void transactionIsActive() {
	   assertTrue(getTransaction().isActive());
	}
	   
	@Override
	public EntityManager entityManager() {
		return em;
	}
}
