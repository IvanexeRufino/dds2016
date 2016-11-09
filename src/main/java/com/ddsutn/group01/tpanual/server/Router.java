package com.ddsutn.group01.tpanual.server;

import com.ddsutn.group01.tpanual.server.controllers.LoginController;
import com.ddsutn.group01.tpanual.server.utils.HandlebarsTemplateEngineBuilder;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

class Router {

    static void configure() {
        HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
            .create()
            .withDefaultHelpers()
//            .withHelper("isTrue", BooleanHelper.isTrue)
            .build();

        Spark.staticFiles.location("/public");

        Spark.get("/", LoginController::login, engine);
    }

}
