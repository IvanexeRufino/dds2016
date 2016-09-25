package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.tools.reporters.Reporter;

import javax.persistence.Transient;
import java.util.HashMap;

public class ActionWithTerminalReport extends Action {

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

    public void updateReportParcial(String searchText, Integer cantidadDeResultados) {
        reporter.updateReport(searchText, cantidadDeResultados,parcial);
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
    public void postcondition(String searchText, int result, String nombre) {
        updateReportParcial(searchText, result);
        updateReportTotal(result,nombre);

    }

}
