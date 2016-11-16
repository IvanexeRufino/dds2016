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
    
    public static ModelAndView filtrar(Request request, Response response) {

        return new ModelAndView(null, "admin/consultas/filtrar.hbs");
    }
    
    public static ModelAndView historial(Request request, Response response) {

        return new ModelAndView(null, "admin/consultas/historial.hbs");
    }
    
    public ModelAndView agregarPoi(Request request, Response response) {
    	Point coordenadas = new Point(Double.parseDouble(request.queryParams("lat")),Double.parseDouble(request.queryParams("long")));
    	switch(request.queryParams("tipo")){
    	case "CGP":
    		CentrosDeGestionYParticipacion cgp = new CentrosDeGestionYParticipacion(request.queryParams("nombre"),new Polygon());
    		cgp.agregarPalabraClave(request.queryParams("PalabraClave"));
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(cgp);
    		});
    		break;
    	case "Banco":
    		SucursalBanco banco = new SucursalBanco(request.queryParams("nombre"),coordenadas);
    		banco.agregarPalabraClave(request.queryParams("PalabraClave"));
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(banco);
    		});
    		break;
    	case "Local":
    		LocalComercial local = new LocalComercial(request.queryParams("nombre"),coordenadas);
    		local.agregarPalabraClave(request.queryParams("PalabraClave"));
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(local);
    		});
    		break;
    	case "ParadaColectivo":
    		ParadaColectivo colectivo = new ParadaColectivo(request.queryParams("nombre"),coordenadas);
    		colectivo.agregarPalabraClave(request.queryParams("PalabraClave"));
    		withTransaction(() ->{
    			PoiRepository.getInstance().add(colectivo);
    		});
    		break;
    	}
    	response.redirect("/admin");
    	return null;
    }
    
}
