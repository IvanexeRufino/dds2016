package com.ddsutn.group01.tpanual.tools.reporters;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.joda.time.LocalDate;

import com.ddsutn.group01.tpanual.repositories.actions.Action;

@Entity
public class Report extends Action{
	
	@Transient
    private Reporter reporter;
	@Transient
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
