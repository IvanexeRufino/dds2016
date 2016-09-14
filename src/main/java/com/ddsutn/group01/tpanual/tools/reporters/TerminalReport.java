package com.ddsutn.group01.tpanual.tools.reporters;

import java.util.HashMap;

import javax.persistence.Transient;

import com.ddsutn.group01.tpanual.repositories.actions.Action;

public class TerminalReport extends Action {

	//MISMO QUE EN REPORT
	@Transient
    private HashMap<String, Integer> parcial = new HashMap<>();
	@Transient
    private HashMap<String, Integer> total = new HashMap<>();
	@Transient
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
