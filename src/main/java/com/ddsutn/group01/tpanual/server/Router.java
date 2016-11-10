package com.ddsutn.group01.tpanual.server;

import com.ddsutn.group01.tpanual.server.controllers.AdminController;
import com.ddsutn.group01.tpanual.server.controllers.RootController;
import com.ddsutn.group01.tpanual.server.controllers.SignInController;
import com.ddsutn.group01.tpanual.server.controllers.TerminalController;
import com.ddsutn.group01.tpanual.server.utils.HandlebarsTemplateEngineBuilder;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

class Router {

    static void configure() {
        HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
            .create()
            .withDefaultHelpers()
            .build();

        Spark.staticFiles.location("/public");

        Spark.get("/", RootController::main, engine);
        Spark.get("/sign_in", SignInController::index, engine);
        Spark.post("/sign_in", SignInController::signIn, engine);
        Spark.get("/admin", AdminController::index, engine);
        Spark.get("/terminal", TerminalController::index, engine);
        Spark.get("/terminal/pois", TerminalController::pois, engine);
        Spark.get("/terminal/poi/:id", TerminalController::poi, engine);
    }

}
