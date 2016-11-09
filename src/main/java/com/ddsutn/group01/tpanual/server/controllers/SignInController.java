package com.ddsutn.group01.tpanual.server.controllers;

import com.ddsutn.group01.tpanual.repositories.UserRepository;
import com.ddsutn.group01.tpanual.server.utils.SessionHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

public class SignInController {

    public static ModelAndView index(Request request, Response response) {
        return new ModelAndView(null, "sign_in/sign_in.hbs");
    }

    public static ModelAndView signIn(Request request, Response response) {
        String username = request.queryParams("user");
        String password = request.queryParams("password");

        if (username == null || password == null) {
            response.redirect("/sign_in");
        }

        Object user = UserRepository.authenticate(username, password);

        if (user != null) {
            request.session().attribute(SessionHelper.SESSION_NAME, username);
            response.redirect("/terminal");
        } else {
            halt(500);
        }

        return null;
    }

}
