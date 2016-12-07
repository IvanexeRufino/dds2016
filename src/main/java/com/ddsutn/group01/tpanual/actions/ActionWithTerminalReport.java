package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.tools.reporters.Reporter;

import javax.persistence.*;
import java.util.HashMap;

@Entity
public class ActionWithTerminalReport extends Action {

    //MISMO QUE EN REPORT
    @Transient
    private HashMap<String, Integer> partialReport = new HashMap<>();
    @Transient
    private HashMap<String, Integer> fullReport = new HashMap<>();
    @Transient
    private Reporter reporter;

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void updateReportParcial(String searchText, Integer cantidadDeResultados) {
        reporter.updateReport(searchText, cantidadDeResultados, partialReport);
    }

    public void updateReportTotal(Integer cantidadDeResultados, String nombre) {
        reporter.updateReport(nombre, cantidadDeResultados, fullReport);
    }

    public HashMap<String, Integer> getReporteParcial() {
        return partialReport;
    }

    public HashMap<String, Integer> getReporteTotal() {
        return fullReport;
    }

    @Override
    public void precondition() {

    }

    @Override
    public void postcondition(String searchText, int result, String nombreDeTerminal) {
        updateReportParcial(searchText, result);
        updateReportTotal(result, nombreDeTerminal);

    }

}
