package com.ddsutn.group01.tpanual.procesos.filters;

import com.ddsutn.group01.tpanual.roles.Terminal;

import java.util.List;
import java.util.stream.Collectors;

public class TerminalesDeterminadasFilter implements TerminalesFilter {

    private List<Terminal> terminales;

    public TerminalesDeterminadasFilter(List<Terminal> terminales) {
        this.terminales = terminales;
    }

    @Override
    public List<Terminal> filtrar(List<Terminal> terminales) {
        return this.terminales.stream().filter(terminales::contains).collect(Collectors.toList());
    }

}
