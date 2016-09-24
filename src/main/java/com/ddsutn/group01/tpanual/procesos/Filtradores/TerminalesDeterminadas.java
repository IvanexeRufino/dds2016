package com.ddsutn.group01.tpanual.procesos.Filtradores;

import java.util.List;

import com.ddsutn.group01.tpanual.roles.Terminal;

public class TerminalesDeterminadas implements FiltradorDeTerminales {

    private List<Terminal> terminales;

    public TerminalesDeterminadas(List<Terminal> terminales) {
        this.terminales = terminales;
    }

    @Override
    public List<Terminal> filtrar(List<Terminal> terminales) {
        return this.terminales;
    }

}
