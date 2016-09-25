package com.ddsutn.group01.tpanual.procesos.filters;

import com.ddsutn.group01.tpanual.roles.Terminal;

import java.util.List;
import java.util.stream.Collectors;

public class ComunaFilter implements TerminalesFilter {

    private int comuna;

    public ComunaFilter(int comuna) {
        this.comuna = comuna;
    }

    @Override
    public List<Terminal> filtrar(List<Terminal> terminales) {
        return terminales.stream()
            .filter(terminal -> terminal.getComuna() == comuna).collect(Collectors.toList());
    }
}
