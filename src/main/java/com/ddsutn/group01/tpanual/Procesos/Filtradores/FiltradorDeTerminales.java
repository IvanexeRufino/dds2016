package com.ddsutn.group01.tpanual.Procesos.Filtradores;

import java.util.List;

import com.ddsutn.group01.tpanual.Roles.Terminal;

public interface FiltradorDeTerminales {
    public List<Terminal> filtrar(List<Terminal> terminales);
}
