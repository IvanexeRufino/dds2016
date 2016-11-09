package com.ddsutn.group01.tpanual.repositories;

public class UserRepository {
    public static Object authenticate(String userName, String password) {
        // Buscar de manera polimorfica entre terminales y admins el userName y comprar
        // si la password coincide, de ser así devuelvo el usuario

        if (userName.equals("user") && password.equals("password")) {
            return new Object();
        }

        return null;
    }
}
