package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.ddsutn.group01.tpanual.actions.ActionWithAdminNotification;
import com.ddsutn.group01.tpanual.actions.ActionWithReport;
import com.ddsutn.group01.tpanual.actions.ActionWithSearchMetrics;
import com.ddsutn.group01.tpanual.actions.ActionWithTerminalReport;
import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.buscador.ResultadoBusqueda;
import com.ddsutn.group01.tpanual.db.BigDecimalConverter;
import com.ddsutn.group01.tpanual.db.JodaDateTimeConverter;
import com.ddsutn.group01.tpanual.db.JodaLocalTimeConverter;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.UserRepository;
import com.ddsutn.group01.tpanual.roles.Terminal;
import com.mongodb.MongoClient;

public class AdminController implements WithGlobalEntityManager, TransactionalOps{

    public static ModelAndView index(Request request, Response response) {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Admin - Matías");

        return new ModelAndView(user, "admin/index.hbs");
    }
    
    public static ModelAndView filtrar(Request request, Response response) {
//    	String desde = request.queryParams("desde");
//    	String hasta = request.queryParams("hasta");
//    	String cantidad = request.queryParams("cantidad");
//    	String terminal= request.queryParams("terminal");
//    	final Morphia morphia = new Morphia();
//    	Datastore datastore;
//    	datastore = morphia.createDatastore(new MongoClient(), "pois");
//    	datastore.ensureIndexes();
//    	
//    	if (desde.isEmpty() && hasta.isEmpty() && cantidad.isEmpty() && terminal.isEmpty()){
//        	List<PointOfInterest> pois = datastore.find(ResultadoBusqueda.class).get().getResultados();
//          Map<String, Object> context = new HashMap<>();
//          ResultadoBusqueda query = datastore.find(ResultadoBusqueda.class).get();
//          context.put("query", query.getSearchText());
//          context.put("pois", pois);
//    	}    	
    	
        return new ModelAndView(null, "admin/consultas/filtrar.hbs");
    }
    
    public static ModelAndView historial(Request request, Response response) {
//    	Poder entrar a una búsqueda y visualizar los POIs devueltos en dicha consulta.
        final Morphia morphia = new Morphia();
        morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaDateTimeConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaLocalTimeConverter.class);
        morphia.mapPackage("com.ddsutn.group01.tpanual.buscador");
        morphia.mapPackage("com.ddsutn.group01.tpanual.models.pois");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "pois");
        datastore.ensureIndexes();
    	
        Map<String, Object> context = new HashMap<>();
        Query<ResultadoBusqueda> query = datastore.find(ResultadoBusqueda.class);
        context.put("busquedas", query);
        return new ModelAndView(context, "admin/consultas/historial.hbs");
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
    	String query2 = request.queryParams("tipo");
    	Map<String, List<PointOfInterest>> pois = new HashMap<>();
    	List<PointOfInterest> filtrados = new ArrayList<>();
    	if(query2 == null && query1 == null) {
        	filtrados = PoiRepository.getInstance().findAll("");
    	} else if(query2 == null && query1 != null) {
    		filtrados = PoiRepository.getInstance().findAll(query1);
    		} else if(query2!= null && query1 == null) {
    			filtrados = PoiRepository.getInstance().findTypeOfPOI(query2);
    		} else {
    			List<PointOfInterest> filtradosPorTipo = PoiRepository.getInstance().findTypeOfPOI(query2);
    			List<PointOfInterest> filtradosPorNombre = filtrados = PoiRepository.getInstance().findAll(query1);
    			filtrados = filtradosPorTipo.stream().filter(filtradosPorNombre::contains).collect(Collectors.toList());
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
    	Buscador buscador = new Buscador(request.queryParams("nombre"));
    	Terminal terminal = new Terminal(request.queryParams("nombre"),Integer.parseInt(request.queryParams("comuna")),buscador);
    	terminal.setUsername(request.queryParams("nombre"));
    	terminal.setPassword(request.queryParams("pass"));
    	if(request.queryParams("mail") != null) {
    		terminal.addAction(new ActionWithAdminNotification());
    		terminal.setMail(true);
    	}
    	if(request.queryParams("report") != null) {
    		terminal.addAction(new ActionWithReport());
    		terminal.setReport(true);
    	}
    	if(request.queryParams("search Metrics") != null) {
    		terminal.addAction(new ActionWithSearchMetrics());
    		terminal.setMetrics(true);
    	}
    	if(request.queryParams("terminal Report") != null) {
    		terminal.addAction(new ActionWithTerminalReport());
    		terminal.setTerminal(true);
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
    
    public ModelAndView modificarTerminal(Request request, Response response) {
    	int id = Integer.parseInt(request.params(":id"));
    	Terminal terminal = UserRepository.getInstance().get(id);
    	terminal.setUsername(request.queryParams("nombre"));
    	terminal.setNombreDeTerminal(request.queryParams("nombre"));
    	terminal.setComuna(Integer.parseInt(request.queryParams("comuna")));
    	terminal.setPassword(request.queryParams("pass"));
    	if(request.queryParams("mail") != null) {
    		if(!terminal.getMail()){
	    		terminal.addAction(new ActionWithAdminNotification());
	    		terminal.setMail(true);
    		}
    	} else {
    		if(terminal.getMail()){
    			ActionWithAdminNotification admAct =  (ActionWithAdminNotification) terminal.getAcciones().get(0);
    			terminal.removeAction(admAct);
    			terminal.setMail(false);
    		}
    	}
    	if(request.queryParams("report") != null) {
    		if(!terminal.getReport()){
	    		terminal.addAction(new ActionWithReport());
	    		terminal.setReport(true);
    		}
    	} else {
    		if(terminal.getReport()){
    			ActionWithReport admAct =  (ActionWithReport) terminal.getAcciones().get(0);
    			terminal.removeAction(admAct);
    			terminal.setReport(false);
    		}
    	}
    	if(request.queryParams("metrics") != null) {
    		if(!terminal.getMetrics()){
	    		terminal.addAction(new ActionWithSearchMetrics());
	    		terminal.setMetrics(true);
    		}
    	} else {
    		if(terminal.getMetrics()){
    			ActionWithSearchMetrics admAct =  (ActionWithSearchMetrics) terminal.getAcciones().get(0);
    			terminal.removeAction(admAct);
    			terminal.setMetrics(false);
    		}
    	}
    	if(request.queryParams("terminal") != null) {
    		if(!terminal.getTerminal()){
	    		terminal.addAction(new ActionWithTerminalReport());
	    		terminal.setTerminal(true);
    		}
    	} else {
    		if(terminal.getTerminal()){
    			ActionWithTerminalReport admAct =  (ActionWithTerminalReport) terminal.getAcciones().get(0);
    			terminal.removeAction(admAct);
    			terminal.setTerminal(false);
    		}
    	}
    	withTransaction(() ->{
    		UserRepository.getInstance().update(terminal);
    	});
    	response.redirect("/admin");
    	return null;
    }
}
