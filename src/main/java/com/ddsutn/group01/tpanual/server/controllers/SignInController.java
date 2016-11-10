package com.ddsutn.group01.tpanual.server.controllers;

import com.ddsutn.group01.tpanual.repositories.UserRepository;
import com.ddsutn.group01.tpanual.roles.Admin;
import com.ddsutn.group01.tpanual.roles.Terminal;
import com.ddsutn.group01.tpanual.roles.User;
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

        UserRepository userRepo = new UserRepository();
        User user = userRepo.authenticate(username, password);

        if (user == null) {
            response.redirect("/sign_in");
        }

        request.session().attribute(SessionHelper.SESSION_NAME, username);

        if (user.isAdmin()) {
            response.redirect("/admin");
        } else {
            response.redirect("/terminal");
        }

        return null;
    }

}
