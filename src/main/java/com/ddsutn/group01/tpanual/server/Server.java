package com.ddsutn.group01.tpanual.server;

import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import org.joda.time.LocalTime;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.Spark;
import spark.debug.DebugScreen;

import java.time.DayOfWeek;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) {
        // new Bootstrap().init();
        Spark.port(9000);
        DebugScreen.enableDebugScreen();
        Router.configure();
    }

}
