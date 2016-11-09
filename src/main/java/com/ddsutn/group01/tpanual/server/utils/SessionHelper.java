package com.ddsutn.group01.tpanual.server.utils;

import spark.Session;

public class SessionHelper {

    public static final String SESSION_NAME = "username";

    public static boolean loggedIn(Session session) {
        String name = session.attribute(SESSION_NAME);

        return name != null;
    }

}
