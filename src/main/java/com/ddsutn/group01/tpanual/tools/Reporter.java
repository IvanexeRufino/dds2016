package com.ddsutn.group01.tpanual.tools;

import java.util.HashMap;

import org.joda.time.LocalDate;

public class Reporter {
    
    private HashMap<LocalDate,Integer> reporte = new HashMap<LocalDate,Integer>();
    
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
