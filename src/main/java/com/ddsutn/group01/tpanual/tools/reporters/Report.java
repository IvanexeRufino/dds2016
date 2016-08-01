package com.ddsutn.group01.tpanual.tools.reporters;

import java.util.HashMap;
import org.joda.time.LocalDate;

import com.ddsutn.group01.tpanual.repositories.actions.Action;

public class Report implements Action{
    private Reporter reporter;
    private HashMap<String, Integer> data = new HashMap<>();

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void updateReport() {
        String fecha = LocalDate.now().toString();
        reporter.updateReport(fecha,1,data);
    }

    public HashMap<String, Integer>  getReport() {
        return data;
    }

    @Override
    public void precondition() {
        
    }

    @Override
    public void postcondition(String criteria, int result, String nombre) {
        updateReport();
        
    }
}
