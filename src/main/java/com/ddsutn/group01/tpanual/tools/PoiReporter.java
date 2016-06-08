package com.ddsutn.group01.tpanual.tools;

import java.util.HashMap;

import org.joda.time.LocalDate;

public class PoiReporter implements Reporter {

    private HashMap<LocalDate,Integer> reporte = new HashMap<>();

    public void updateReport() {
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
