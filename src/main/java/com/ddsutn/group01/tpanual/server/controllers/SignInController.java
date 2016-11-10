package com.ddsutn.group01.tpanual.server.controllers;

import com.ddsutn.group01.tpanual.roles.User;
import com.ddsutn.group01.tpanual.server.utils.SessionHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class SignInController {

    public static ModelAndView index(Request request, Response response) {
        return new ModelAndView(null, "sign_in/sign_in.hbs");
    }

    public static ModelAndView signIn(Request request, Response response) {
        String username = request.queryParams("user");
        String password = request.queryParams("password");

        if (username == null || password == null) {
            response.redirect("/sign_in");
            return null;
        }

        User user = SessionHelper.authenticate(username, password);

        if (user == null) {
            response.redirect("/sign_in");
            return null;
        }

        SessionHelper.saveSession(username, request.session());
        response.redirect("/");

        return null;
    }

}
