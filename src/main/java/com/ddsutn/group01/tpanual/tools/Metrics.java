package com.ddsutn.group01.tpanual.tools;

import java.util.ArrayList;

public class Metrics {

    private static Metrics instance = null;
    private InfoAlmacenada info;
    private ArrayList<InfoAlmacenada> listado = new ArrayList<>();

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
}
