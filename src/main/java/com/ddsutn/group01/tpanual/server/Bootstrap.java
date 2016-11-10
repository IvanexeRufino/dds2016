package com.ddsutn.group01.tpanual.server;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.roles.Terminal;


public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps{
	
	public void init(){
		withTransaction(() ->{
			Terminal proyecto = new Terminal();
			persist(proyecto);
		
		});
	}

}
