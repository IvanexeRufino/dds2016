package com.ddsutn.group01.tpanual.tools;

import java.util.ArrayList;

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
        informacion = new InfoAlmacenada(criteria,cantidadDeResultados,tiempo);
        listado.add(informacion);      
    }
    
}
