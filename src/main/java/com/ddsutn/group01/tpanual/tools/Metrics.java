package com.ddsutn.group01.tpanual.tools;

import java.util.ArrayList;

import org.joda.time.LocalDate;

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
        org.joda.time.LocalDate date = LocalDate.now();
        info = new InfoAlmacenada(criteria, resultsCount, timeLapsed, date);
        listado.add(info);
    }

}
