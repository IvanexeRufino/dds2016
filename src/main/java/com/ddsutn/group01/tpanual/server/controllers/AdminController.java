package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.actions.ActionWithAdminNotification;
import com.ddsutn.group01.tpanual.actions.ActionWithReport;
import com.ddsutn.group01.tpanual.actions.ActionWithSearchMetrics;
import com.ddsutn.group01.tpanual.actions.ActionWithTerminalReport;
import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.UserRepository;
import com.ddsutn.group01.tpanual.roles.Terminal;

public class AdminController implements WithGlobalEntityManager, TransactionalOps{

    public static ModelAndView index(Request request, Response response) {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Admin - Matías");

        return new ModelAndView(user, "admin/index.hbs");
    }
    
    public static ModelAndView filtrar(Request request, Response response) {

        return new ModelAndView(null, "admin/consultas/filtrar.hbs");
    }
    
    public static ModelAndView historial(Request request, Response response) {

        return new ModelAndView(null, "admin/consultas/historial.hbs");
    }
    
    public static ModelAndView modificarPoi(Request request, Response response) {
    	int id = Integer.parseInt(request.params(":id"));
    	Map<String, PointOfInterest> pois = new HashMap<>();
    	PointOfInterest poi = PoiRepository.getInstance().findOne(id);
    	pois.put("poi", poi);
        return new ModelAndView(pois, "admin/pois/modificar.hbs");
    }
    
    public ModelAndView guardarModificacion(Request request, Response response) {
    	int id = Integer.parseInt(request.params(":id"));
    	PointOfInterest poi = PoiRepository.getInstance().findOne(id);
    	poi.setName(request.queryParams("nombre"));
    	Point nuevoPunto = new Point(Double.parseDouble(request.queryParams("latitude")),Double.parseDouble(request.queryParams("longitude")));
    	poi.setPoint(nuevoPunto);
    	withTransaction(() ->{
    		PoiRepository.getInstance().edit(poi);
    	});
    	response.redirect("/admin");
        return null;
    }
    
    public static ModelAndView listar(Request request, Response response) {
    	String query1 = request.queryParams("nombre");
    	Map<String, List<PointOfInterest>> pois = new HashMap<>();
    	List<PointOfInterest> filtrados = new ArrayList<>();
    	if(query1 == null) {
        	filtrados = PoiRepository.getInstance().findAll("");
    	}
    	else {
    		filtrados = PoiRepository.getInstance().findAll(query1);
    	}
    	pois.put("filtrados", filtrados);
        return new ModelAndView(pois, "admin/pois/pois.hbs");
    }
    
    public ModelAndView eliminar(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
    	withTransaction(() ->{
    		PoiRepository.getInstance().remove(id);
    	});
    	response.redirect("/admin");
    	return null;
    }
    
    public static ModelAndView nueva(Request request, Response response) {
    	
    	return new ModelAndView(null, "admin/terminales/nueva.hbs");
    }
    
    public ModelAndView agregarTerminal(Request request, Response response) {
    	Buscador buscador = new Buscador();
    	Terminal terminal = new Terminal(request.queryParams("nombre"),Integer.parseInt(request.queryParams("comuna")),buscador);
    	terminal.setUsername(request.queryParams("nombre"));
    	terminal.setPassword(request.queryParams("pass"));
    	if(request.queryParams("mail") != null) {
    		terminal.addAction(new ActionWithAdminNotification(null));
    	}
    	if(request.queryParams("report") != null) {
    		terminal.addAction(new ActionWithReport());
    	}
    	if(request.queryParams("search Metrics") != null) {
    		terminal.addAction(new ActionWithSearchMetrics());
    	}
    	if(request.queryParams("terminal Report") != null) {
    		terminal.addAction(new ActionWithTerminalReport());
    	}
    	withTransaction(() ->{
    		UserRepository.getInstance().add(terminal);
    	});
    	response.redirect("/admin");
    	return null;
    }
    
    public static ModelAndView listarTerminales(Request request, Response response) {
    	String query = request.queryParams("comuna");
    	List<Terminal> terminales;
    	Map<String, List<Terminal>> model = new HashMap<>();
    	if(query == null || query.isEmpty()) {
	    	terminales = UserRepository.getInstance().getAll();
    	}
    	else {
        	int comuna = Integer.parseInt(query);
    		terminales = UserRepository.getInstance().getAll().stream()
    									.filter(terminal->terminal.getComuna() == comuna)
    									.collect(Collectors.toList());
    	}
    	model.put("terminales", terminales);
    	return new ModelAndView(model, "admin/terminales/terminales.hbs");
    }
    
    public static ModelAndView terminal(Request request, Response response) {
    	Map<String, Terminal> model = new HashMap<>();
    	Terminal terminal = UserRepository.getInstance().get(Integer.parseInt(request.params(":id")));
    	model.put("terminal", terminal);
    	return new ModelAndView(model, "admin/terminales/modificar.hbs");
    }
    
    public ModelAndView eliminarTerminal(Request request, Response response) {
    	int id = Integer.parseInt(request.params(":id"));
    	withTransaction(() ->{
    		UserRepository.getInstance().remove(id);;
    	});
    	response.redirect("/admin");
    	return null;
    }
}
