package com.ddsutn.group01.tpanual.procesos.filters;

import java.util.List;

import com.ddsutn.group01.tpanual.roles.Terminal;

public class TodasLasTerminalesFilter implements TerminalesFilter {

    @Override
    public List<Terminal> filtrar(List<Terminal> terminales) {
        return terminales;
    }

}
