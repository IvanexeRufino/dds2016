package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AdminController {

    public static ModelAndView index(Request request, Response response) {
        return new ModelAndView(null, "admin/index.hbs");
    }

}
