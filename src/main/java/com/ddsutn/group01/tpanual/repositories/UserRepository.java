package com.ddsutn.group01.tpanual.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.roles.User;

public class UserRepository implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {
    public User authenticate(String username, String password) {

        List<User> usuarios = (List<User>) createQuery("FROM User").getResultList();
        List<User> filtros = usuarios.stream().filter(terminal -> terminal.getUsername().equals(username) && terminal.getPassword().equals(password))
            .collect(Collectors.toList());

        if (filtros.size() == 1) {
            return filtros.get(0);
        }

        return null;
    }
}
