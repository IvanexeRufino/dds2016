package com.ddsutn.group01.tpanual.server.controllers;

import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TerminalController {
	
	private Buscador buscador;

    public static ModelAndView index(Request request, Response response) {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Matías");
        
        return new ModelAndView(user, "terminal/index.hbs");
    }

    public static ModelAndView pois(Request request, Response response) {
        String query = request.queryParams("query");

        if (query.isEmpty()) {
            return new ModelAndView(null, "terminal/pois.hbs");
        }

        
        List<PointOfInterest> pois = PoiRepository.getInstance().findAll(query);
        Map<String, Object> context = new HashMap<>();
        context.put("query", query);
        context.put("pois", pois);


        // TODO: paginate results
        return new ModelAndView(context, "terminal/pois.hbs");
    }

    public static ModelAndView poi(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        PointOfInterest poi = PoiRepository.getInstance().findOne(id);

        return new ModelAndView(poi, "terminal/poi.hbs");
    }

}
