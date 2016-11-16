package com.ddsutn.group01.tpanual.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.roles.Terminal;
import com.ddsutn.group01.tpanual.roles.User;

import javax.persistence.Query;

public class UserRepository implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {
	
	private static UserRepository instance = null;
	
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }

        return instance;
    }
    
    public void add(User usuario) {
        persist(usuario);
    }
    
    public void update(User usuario) {
        merge(usuario);
    }
    
    public void remove(int id) {
    	remove(find(Terminal.class, id));
    }
    
    public Terminal get(int id) {
    	return find(Terminal.class, id);
    }
    
    public List<Terminal> getAll() {
    	return (List<Terminal>) createQuery("from Terminal").getResultList();
    }
	
    public User authenticate(String username, String password) {

        List<User> usuarios = (List<User>) createQuery("FROM User").getResultList();
        List<User> filtros = usuarios.stream().filter(terminal -> terminal.getUsername().equals(username) && terminal.getPassword().equals(password))
            .collect(Collectors.toList());

        if (filtros.size() == 1) {
            return filtros.get(0);
        }

        return null;
    }

    public User find(String username) {
        Query query = createQuery("FROM User WHERE username = :username");
        query.setParameter("username", username);

        return (User) query.getSingleResult();
    }
}
