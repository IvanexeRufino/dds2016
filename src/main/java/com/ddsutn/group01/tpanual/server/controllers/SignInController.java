package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class SignInController {

    public static ModelAndView login(Request request, Response response) {
        return new ModelAndView(null, "sign_in/sign_in.hbs");
    }

}
