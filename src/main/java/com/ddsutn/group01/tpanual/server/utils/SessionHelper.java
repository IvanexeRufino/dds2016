package com.ddsutn.group01.tpanual.server.utils;

import com.ddsutn.group01.tpanual.repositories.UserRepository;
import com.ddsutn.group01.tpanual.roles.User;
import spark.Session;

public class SessionHelper {

    public static final String SESSION_NAME = "username";

    public static boolean loggedIn(Session session) {
        String name = session.attribute(SESSION_NAME);

        return name != null;
    }

    public static User authenticate(String username, String password) {
        UserRepository userRepo = new UserRepository();

        return userRepo.authenticate(username, password);
    }

    public static User findUser(String username) {
        UserRepository userRepo = new UserRepository();

        return userRepo.find(username);
    }

}
