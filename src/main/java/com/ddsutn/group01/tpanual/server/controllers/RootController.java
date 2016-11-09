package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class RootController {

    public static ModelAndView main(Request request, Response response) {
        //if (userLoggedIn) {
        if (true) {
            //String url = isAdmin ? "admin" : "terminal";
            String url = "admin";
            response.redirect(url, 302);
        } else {
            response.redirect("/sign_in", 302);
        }

        return null;
    }

}
