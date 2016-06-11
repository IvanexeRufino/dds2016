//package com.ddsutn.group01.tpanual.repositories.actions;
//
//import java.util.HashMap;
//import java.util.List;
//
//import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
//import com.ddsutn.group01.tpanual.repositories.Repository;
//import com.ddsutn.group01.tpanual.repositories.RepositoryWithActions;
//import com.ddsutn.group01.tpanual.tools.reporters.Reporter;
//
//public class TerminalReport extends RepositoryWithActions {
//
//    private HashMap<String, Integer> parcial = new HashMap<>();
//    static HashMap<String, Integer> total = new HashMap<>();
//    private Reporter reporter;
//    private String terminal;
//
//    TerminalReport(Repository repository, String nombre) {
//        super(repository);
//        terminal = nombre;
//    }
//
//    public void setReporter(Reporter reporter) {
//        this.reporter = reporter;
//    }
//
//    @Override
//    public List<PointOfInterest> find(String criteria) {
//        List<PointOfInterest> result = repository.find(criteria);
//        updateReportParcial(criteria, result.size());
//        updateReportTotal(result.size());
//        return result;
//    }
//
//    public void updateReportParcial(String criteria, Integer cantidadDeResultados) {
//        reporter.updateReport(criteria, cantidadDeResultados,parcial);
//    }
//
//    public void updateReportTotal(Integer cantidadDeResultados) {
//        reporter.updateReport(terminal, cantidadDeResultados, total);
//    }
//
//    public HashMap<String,Integer> getReporteParcial() {
//        return parcial;
//    }
//
//    public HashMap<String,Integer> getReporteTotal() {
//        return total;
//    }
//
//}
