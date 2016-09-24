package com.ddsutn.group01.tpanual.procesos.Log;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Log {
    private static List<ProcessData> almacen = new ArrayList<ProcessData>();

    public void guardar(int resultados, DateTime fecha, String estado) {
        ProcessData data = new ProcessData(resultados,fecha,estado);
        almacen.add(data);
    }
}
