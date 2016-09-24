package com.ddsutn.group01.tpanual.procesos.Filtradores;

import com.ddsutn.group01.tpanual.roles.Terminal;

import java.util.List;

public interface FiltradorDeTerminales {
    List<Terminal> filtrar(List<Terminal> terminales);
}
