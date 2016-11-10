package com.ddsutn.group01.tpanual.server;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.roles.Admin;
import com.ddsutn.group01.tpanual.roles.Terminal;


public class Bootstrap extends AbstractPersistenceTest implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps{
	
	public void init(){
		withTransaction(() ->{
			Terminal proyecto = new Terminal();
			proyecto.setUsername("hola");
			proyecto.setPassword("hola");
			persist(proyecto);
			Admin pro = new Admin();
			pro.setUsername("chau");
			pro.setPassword("chau");
			persist(pro);
		});
	}

}