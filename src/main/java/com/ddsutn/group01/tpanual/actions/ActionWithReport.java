package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.tools.reporters.Reporter;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.HashMap;

@Entity
public class ActionWithReport extends Action {

    @Transient
    private Reporter reporter;

    @Transient
    private HashMap<String, Integer> report = new HashMap<>();

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void updateReport() {
        String fecha = LocalDate.now().toString();
        reporter.updateReport(fecha, 1, report);
    }

    public HashMap<String, Integer> getReport() {
        return report;
    }

    @Override
    public void precondition() {}

    @Override
    public void postcondition(String searchText, int result, String nombreDeTerminal) {
        updateReport();
    }
}
