package com.ddsutn.group01.tpanual.server.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
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

	private static List<CheckBox> checkBoxList = new ArrayList<>();
	
    public static ModelAndView index(Request request, Response response) {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Admin - Matías");

        return new ModelAndView(user, "admin/index.hbs");
    }
    
    public static ModelAndView filtrar(Request request, Response response) {
    	String desde = request.queryParams("desde");
    	String hasta = request.queryParams("hasta");
    	String cantidad = request.queryParams("cantidad");
    	String terminal= request.queryParams("terminal");
        final Morphia morphia = new Morphia();
        morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaDateTimeConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaLocalTimeConverter.class);
        morphia.mapPackage("com.ddsutn.group01.tpanual.buscador");
        morphia.mapPackage("com.ddsutn.group01.tpanual.models.pois");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "pois");
        datastore.ensureIndexes();
    	
		List<ResultadoBusqueda> busquedas = datastore.find(ResultadoBusqueda.class).asList();

		if(!desde.isEmpty()) {
	    	DateTime desdeTime = DateTime.parse(request.queryParams("desde"));
			busquedas = busquedas.stream().filter(res->res.getFecha().toDateTime().isAfter(desdeTime)).collect(Collectors.toList());
		}
		
		if(!hasta.isEmpty()) {
	    	DateTime hastaTime = DateTime.parse(request.queryParams("hasta"));
			busquedas = busquedas.stream().filter(res->res.getFecha().toDateTime().isBefore(hastaTime)).collect(Collectors.toList());
		}
		
		if(!cantidad.isEmpty()) {
			busquedas = busquedas.stream().filter(res->res.getResultados().size() == Integer.parseInt(cantidad)).collect(Collectors.toList());
		}
		
		if(!terminal.equals("Todas")) {
			busquedas = busquedas.stream().filter(res->res.getUsername().equals(terminal)).collect(Collectors.toList());
		}
		
        List<Terminal> terminales = UserRepository.getInstance().getAll();
		Map<String, Object> context = new HashMap<>();
        context.put("busquedas", busquedas);
        context.put("terminales", terminales);
        return new ModelAndView(context, "admin/consultas/filtrar.hbs");
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
    	
        List<Terminal> terminales = UserRepository.getInstance().getAll();
        Map<String, Object> context = new HashMap<>();
        Query<ResultadoBusqueda> query = datastore.find(ResultadoBusqueda.class);
        context.put("busquedas", query);
        context.put("terminales", terminales);
        return new ModelAndView(context, "admin/consultas/historial.hbs");
    }
    
    public static ModelAndView resultados(Request request, Response response) {
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
        List<ResultadoBusqueda> resultados = datastore.find(ResultadoBusqueda.class).asList();
        ResultadoBusqueda resultado = resultados.stream().filter(res->(res.getSearchText().equals(request.params(":searchText")) && res.getUsername().equals(request.params(":username")))).collect(Collectors.toList()).get(0);
        context.put("resultados", resultado.getResultados());
        
        return new ModelAndView(context, "admin/consultas/resultados.hbs");
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
        	checkBoxList.add(new CheckBox(terminal.getUsername(), "mail",true));
//    		terminal.setMail(true);
    	}
    	if(request.queryParams("report") != null) {
    		terminal.addAction(new ActionWithReport());
    		checkBoxList.add(new CheckBox(terminal.getUsername(), "report",true));
    	}
    	if(request.queryParams("search Metrics") != null) {
    		terminal.addAction(new ActionWithSearchMetrics());
    		checkBoxList.add(new CheckBox(terminal.getUsername(), "search Metrics",true));
    	}
    	if(request.queryParams("terminal Report") != null) {
    		terminal.addAction(new ActionWithTerminalReport());
    		checkBoxList.add(new CheckBox(terminal.getUsername(), "terminal Report",true));
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
    	Map<String, Object> model = new HashMap<>();
    	int id = Integer.parseInt(request.params(":id"));
    	Terminal terminal = UserRepository.getInstance().get(id);
    	List<CheckBox> checksDeTerminal = checkBoxList.stream().filter(check->check.getUsername().equals(terminal.getUsername())).collect(Collectors.toList());
    	model.put("terminal", terminal);
    	model.put("mailState", checksDeTerminal.stream().filter(check->check.getNombre().equals("mail")).findFirst().orElse(new CheckBox("","",false)).getState());
    	model.put("reportState", checksDeTerminal.stream().filter(check->check.getNombre().equals("report")).findFirst().orElse(new CheckBox("","",false)).getState());
    	model.put("searchMetricsState", checksDeTerminal.stream().filter(check->check.getNombre().equals("search Metrics")).findFirst().orElse(new CheckBox("","",false)).getState());
    	model.put("terminalReportState", checksDeTerminal.stream().filter(check->check.getNombre().equals("terminal Report")).findFirst().orElse(new CheckBox("","",false)).getState());

    	return new ModelAndView(model, "admin/terminales/modificar.hbs");
    }
    
    public ModelAndView eliminarTerminal(Request request, Response response) {
    	int id = Integer.parseInt(request.params(":id"));
    	checkBoxList.removeIf(check->check.getUsername().equals(UserRepository.getInstance().get(id).getUsername()));
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
    	List<CheckBox> checksDeTerminal = checkBoxList.stream().filter(check->check.getUsername().equals(terminal.getUsername())).collect(Collectors.toList());
    	if(request.queryParams("mail") != null) {
    		if(!checksDeTerminal.stream().filter(check->check.getNombre().equals("mail")).findFirst().orElse(new CheckBox("","",false)).getState()){
	    		terminal.addAction(new ActionWithAdminNotification());
	    		checkBoxList.add(new CheckBox(terminal.getUsername(), "mail",true));
    		}
    	} else {
    		if(checksDeTerminal.stream().filter(check->check.getNombre().equals("mail")).findFirst().orElse(new CheckBox("","",false)).getState()){
    			CheckBox checkMail = checksDeTerminal.stream().filter(check->check.getNombre().equals("mail")).collect(Collectors.toList()).get(0);
    			int index = checksDeTerminal.indexOf(checkMail);
    			ActionWithAdminNotification admAct = (ActionWithAdminNotification) terminal.getAcciones().get(index);
    			terminal.removeAction(admAct);
    			checkBoxList.remove(checkMail);
    		}
    	}
    	if(request.queryParams("report") != null) {
    		if(!checksDeTerminal.stream().filter(check->check.getNombre().equals("report")).findFirst().orElse(new CheckBox("","",false)).getState()){
	    		terminal.addAction(new ActionWithReport());
	    		checkBoxList.add(new CheckBox(terminal.getUsername(), "report",true));
    		}
    	} else {
    		if(checksDeTerminal.stream().filter(check->check.getNombre().equals("report")).findFirst().orElse(new CheckBox("","",false)).getState()){
    			CheckBox checkMail = checksDeTerminal.stream().filter(check->check.getNombre().equals("report")).collect(Collectors.toList()).get(0);
    			int index = checksDeTerminal.indexOf(checkMail);
    			ActionWithReport admAct = (ActionWithReport) terminal.getAcciones().get(index);
    			terminal.removeAction(admAct);
    			checkBoxList.remove(checkMail);
    		}
    	}
    	if(request.queryParams("searchMetrics") != null) {
    		if(!checksDeTerminal.stream().filter(check->check.getNombre().equals("search Metrics")).findFirst().orElse(new CheckBox("","",false)).getState()){
	    		terminal.addAction(new ActionWithAdminNotification());
	    		checkBoxList.add(new CheckBox(terminal.getUsername(), "search Metrics",true));
    		}
    	} else {
    		if(checksDeTerminal.stream().filter(check->check.getNombre().equals("search Metrics")).findFirst().orElse(new CheckBox("","",false)).getState()){
    			CheckBox checkMail = checksDeTerminal.stream().filter(check->check.getNombre().equals("search Metrics")).collect(Collectors.toList()).get(0);
    			int index = checksDeTerminal.indexOf(checkMail);
    			ActionWithSearchMetrics admAct = (ActionWithSearchMetrics) terminal.getAcciones().get(index);
    			terminal.removeAction(admAct);
    			checkBoxList.remove(checkMail);
    		}
    	}
    	if(request.queryParams("terminalReport") != null) {
    		if(!checksDeTerminal.stream().filter(check->check.getNombre().equals("terminal Report")).findFirst().orElse(new CheckBox("","",false)).getState()){
	    		terminal.addAction(new ActionWithAdminNotification());
	    		checkBoxList.add(new CheckBox(terminal.getUsername(), "terminal Report",true));
    		}
    	} else {
    		if(checksDeTerminal.stream().filter(check->check.getNombre().equals("terminal Report")).findFirst().orElse(new CheckBox("","",false)).getState()){
    			CheckBox checkMail = checksDeTerminal.stream().filter(check->check.getNombre().equals("terminal Report")).collect(Collectors.toList()).get(0);
    			int index = checksDeTerminal.indexOf(checkMail);
    			ActionWithTerminalReport admAct = (ActionWithTerminalReport) terminal.getAcciones().get(index);
    			terminal.removeAction(admAct);
    			checkBoxList.remove(checkMail);
    		}
    	}
    	withTransaction(() ->{
    		UserRepository.getInstance().update(terminal);
    	});
    	response.redirect("/admin");
    	return null;
    }
}
