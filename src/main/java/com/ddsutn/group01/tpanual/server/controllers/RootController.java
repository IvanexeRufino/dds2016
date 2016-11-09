package com.ddsutn.group01.tpanual.server.controllers;

import com.ddsutn.group01.tpanual.server.utils.SessionHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class RootController {

    public static ModelAndView main(Request request, Response response) {
        boolean loggedIn = SessionHelper.loggedIn(request.session());

        if (!loggedIn) {
            response.redirect("/sign_in");
        }

        response.redirect("/admin");

        return null;
    }

}
