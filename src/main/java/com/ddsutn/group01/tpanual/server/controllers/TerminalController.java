package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class TerminalController {

    public static ModelAndView index(Request request, Response response) {
        return new ModelAndView(null, "terminal/index.hbs");
    }

}
