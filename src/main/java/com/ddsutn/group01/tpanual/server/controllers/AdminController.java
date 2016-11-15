package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class AdminController implements WithGlobalEntityManager, TransactionalOps{

    public static ModelAndView index(Request request, Response response) {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Admin - Matías");

        return new ModelAndView(user, "admin/index.hbs");
    }
    
    public static ModelAndView newPoi(Request request, Response response) {

        return new ModelAndView(null, "admin/pois/poiNuevo.hbs");
    }
    
    public ModelAndView agregarPoi(Request request, Response response) {
    	Point coordenadas = new Point(Double.parseDouble(request.queryParams("lat")),Double.parseDouble(request.queryParams("long")));
    	switch(request.queryParams("tipo")){
    	case "CGP":
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(new CentrosDeGestionYParticipacion(request.queryParams("nombre"),new Polygon()));
    		});
    		break;
    	case "Banco":
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(new SucursalBanco(request.queryParams("nombre"),coordenadas));
    		});
    		break;
    	case "Local":
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(new LocalComercial(request.queryParams("nombre"),coordenadas));
    		});
    		break;
    	case "ParadaColectivo":
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(new ParadaColectivo(request.queryParams("nombre"),coordenadas));
    		});
    		break;
    	}
    	response.redirect("/admin");
    	return null;
    }
    
}
