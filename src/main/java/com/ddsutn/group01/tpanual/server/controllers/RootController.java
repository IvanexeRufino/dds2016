package com.ddsutn.group01.tpanual.server.controllers;

import com.ddsutn.group01.tpanual.roles.User;
import com.ddsutn.group01.tpanual.server.utils.SessionHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import static com.ddsutn.group01.tpanual.server.utils.SessionHelper.SESSION_NAME;

public class RootController {

    public static ModelAndView main(Request request, Response response) {
        User user = SessionHelper.findUser(request.session().attribute(SESSION_NAME));

        if (user.isAdmin()) {
            response.redirect("/admin");
        } else {
            response.redirect("/terminal");
        }

        return null;
    }

}
