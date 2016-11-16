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
        Spark.get("/admin/POIS", AdminController::listar, engine);
        Spark.get("/admin/POIS/:id", adminController::eliminar, engine);
        Spark.get("/admin/POIS/modificar/:id", AdminController::modificarPoi, engine);
        Spark.post("/admin/POIS/modificar/:id", adminController::guardarModificacion, engine);
        
        Spark.get("/admin/terminales/Agregar", AdminController::nueva, engine);
        Spark.post("/admin/terminales/Agregar", adminController::agregarTerminal, engine);
        
        Spark.get("/admin/terminales", AdminController::listarTerminales, engine);
        Spark.get("/admin/terminales/modificar/:id", AdminController::terminal,engine);
        Spark.post("/admin/terminales/modificar/:id", adminController::modificarTerminal,engine);
        Spark.get("/admin/terminales/:id", adminController::eliminarTerminal,engine);
        
        
        Spark.get("/admin/consultas/filtrar", AdminController::filtrar,engine);
        Spark.get("/admin/consultas/historial", AdminController::historial,engine);
        
        
        Spark.get("/terminal", TerminalController::index, engine);
        Spark.get("/terminal/pois", TerminalController::pois, engine);
        Spark.get("/terminal/poi/:id", TerminalController::poi, engine);
    }

}
