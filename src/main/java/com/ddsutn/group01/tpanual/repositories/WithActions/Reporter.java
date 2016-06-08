package com.ddsutn.group01.tpanual.repositories.WithActions;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Reporter {
    
    private static Reporter instance = null;
    private InfoAlmacenada informacion;
    private ArrayList<InfoAlmacenada> listado = new ArrayList<>();
    
    public static Reporter getInstance() {
        if (instance == null) {
            instance = new Reporter();
        }

        return instance;
    }

    public void almacenarResultados(String criteria, int cantidadDeResultados, long tiempo) {
        DateTime fecha = DateTime.now();
        informacion = new InfoAlmacenada(criteria,cantidadDeResultados,tiempo,fecha);
        listado.add(informacion);
    }
    
}
