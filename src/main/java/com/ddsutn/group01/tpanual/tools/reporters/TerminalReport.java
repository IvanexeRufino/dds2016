package com.ddsutn.group01.tpanual.tools.reporters;

import java.util.HashMap;

import com.ddsutn.group01.tpanual.repositories.actions.Action;

public class TerminalReport implements Action {

    private HashMap<String, Integer> parcial = new HashMap<>();
    private HashMap<String, Integer> total = new HashMap<>();
    private Reporter reporter;

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void updateReportParcial(String criteria, Integer cantidadDeResultados) {
        reporter.updateReport(criteria, cantidadDeResultados,parcial);
    }

    public void updateReportTotal(Integer cantidadDeResultados, String nombre) {
        reporter.updateReport(nombre, cantidadDeResultados, total);
    }

    public HashMap<String,Integer> getReporteParcial() {
        return parcial;
    }

    public HashMap<String,Integer> getReporteTotal() {
        return total;
    }

    @Override
    public void precondition() {
        
    }

    @Override
    public void postcondition(String criteria, int result, String nombre) {
        updateReportParcial(criteria, result);
        updateReportTotal(result,nombre);
        
    }

}
