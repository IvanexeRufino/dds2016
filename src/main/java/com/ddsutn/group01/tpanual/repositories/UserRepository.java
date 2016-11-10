package com.ddsutn.group01.tpanual.repositories;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.roles.User;

public class UserRepository implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps{
    public User authenticate(String userName, String password) {
    	
    	List<User> usuarios = (List<User>)createQuery("FROM User").getResultList();
    	usuarios.stream().filter(terminal->terminal.getUsername().equals("user") && terminal.getPassword().equals("password"));

        if (usuarios.size() == 1) {
            return usuarios.get(0);
        }

        return null;
    }
}
