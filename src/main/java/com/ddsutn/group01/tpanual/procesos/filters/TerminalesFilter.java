package com.ddsutn.group01.tpanual.procesos.filters;

import com.ddsutn.group01.tpanual.roles.Terminal;

import java.util.List;

public interface TerminalesFilter {
    List<Terminal> filtrar(List<Terminal> terminales);
}
