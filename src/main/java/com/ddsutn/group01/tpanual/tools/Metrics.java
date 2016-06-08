package com.ddsutn.group01.tpanual.tools;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.LocalDate;

public class Metrics {

    private static Metrics instance = null;
    private InfoAlmacenada info;
    private ArrayList<InfoAlmacenada> listado = new ArrayList<>();
    private HashMap<LocalDate,Integer> reporte = new HashMap<LocalDate,Integer>();

    public static Metrics getInstance() {
        if (instance == null) {
            instance = new Metrics();
        }

        return instance;
    }

    public void reportStat(String criteria, int resultsCount, long timeLapsed) {
        info = new InfoAlmacenada(criteria, resultsCount, timeLapsed);
        listado.add(info);
    }

    public ArrayList<InfoAlmacenada> getListado() {
        return listado;
    }
    
    public void actualizarReporte() {
        LocalDate date = LocalDate.now();
        if (reporte.containsKey(date))
        {   Integer CantidadDeResultados = reporte.get(date);
            CantidadDeResultados += CantidadDeResultados;
            reporte.put(date, CantidadDeResultados);
        }
        else {
            reporte.put(date, 1);
        }
    }
    
    public HashMap<LocalDate,Integer> obtenerReporte() {
        return reporte;
    }
}
