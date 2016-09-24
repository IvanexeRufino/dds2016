package com.ddsutn.group01.tpanual.procesos.Filtradores;

import java.util.List;

import com.ddsutn.group01.tpanual.roles.Terminal;

public class TodasLasTerminales implements FiltradorDeTerminales {

    @Override
    public List<Terminal> filtrar(List<Terminal> terminales) {
        return terminales;
    }

}
