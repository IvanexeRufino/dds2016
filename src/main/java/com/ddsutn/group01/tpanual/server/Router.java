package com.ddsutn.group01.tpanual.server;

import com.ddsutn.group01.tpanual.server.controllers.AdminController;
import com.ddsutn.group01.tpanual.server.controllers.RootController;
import com.ddsutn.group01.tpanual.server.controllers.SignInController;
import com.ddsutn.group01.tpanual.server.controllers.TerminalController;
import com.ddsutn.group01.tpanual.server.utils.HandlebarsTemplateEngineBuilder;
import com.ddsutn.group01.tpanual.server.utils.SessionHelper;

import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.before;
import static spark.Spark.halt;

class Router {

    static void configure() {
        HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
            .create()
            .withDefaultHelpers()
            .build();

        Spark.staticFiles.location("/public");

        before((Request request, Response response) -> {
            if (!request.pathInfo().equals("/sign_in")) {
                boolean loggedIn = SessionHelper.loggedIn(request.session());

                if (!loggedIn) {
                    response.redirect("/sign_in");
                    halt(200);
                }
            }
        });
        
        AdminController adminController = new AdminController();

        Spark.get("/", RootController::main, engine);
        Spark.get("/sign_in", SignInController::index, engine);
        Spark.post("/sign_in", SignInController::signIn, engine);
        Spark.get("/admin", AdminController::index, engine);
        Spark.get("/admin/POIS/Agregar", AdminController::newPoi, engine);
        Spark.post("/admin/POIS/Agregar", adminController::agregarPoi, engine);
        Spark.get("/terminal", TerminalController::index, engine);
        Spark.get("/terminal/pois", TerminalController::pois, engine);
        Spark.get("/terminal/poi/:id", TerminalController::poi, engine);
    }

}
