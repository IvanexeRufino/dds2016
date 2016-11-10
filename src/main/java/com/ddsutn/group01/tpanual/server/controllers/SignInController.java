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

        UserRepository repo = new UserRepository();
        
        User user =repo.authenticate(username, password);

        if (user == null) {
            halt(500);
        }
        if (user.queSos() == "terminal") {
            request.session().attribute(SessionHelper.SESSION_NAME, username);
            response.redirect("/terminal");
        } else {
        		request.session().attribute(SessionHelper.SESSION_NAME, username);
                response.redirect("/admin");
        }

        return null;
    }

}
