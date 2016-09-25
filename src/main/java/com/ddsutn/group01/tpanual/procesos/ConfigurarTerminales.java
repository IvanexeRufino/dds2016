package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.procesos.Filtradores.FiltradorDeTerminales;
import com.ddsutn.group01.tpanual.roles.Terminal;
import com.ddsutn.group01.tpanual.actions.Action;

import java.util.List;

public class ConfigurarTerminales extends com.ddsutn.group01.tpanual.procesos.Proceso {
    private List<Action> acciones;
    private List<Terminal> terminales;
    private FiltradorDeTerminales filtrador;

    public ConfigurarTerminales(FiltradorDeTerminales unFiltro, List<Terminal> unasTerminales) {
        filtrador = unFiltro;
        terminales = unasTerminales;
    }

    public void setTerminales(List<Terminal> unasTerminales) {
        terminales = unasTerminales;
    }

    public void setAcciones(List<Action> acciones) {
        this.acciones = acciones;
    }

    public int ejecutar() throws Exception{
        List<Terminal> terminalesAEjecutar = filtrador.filtrar(terminales);
        terminalesAEjecutar.forEach(terminal -> terminal.setActions(acciones));
        return terminalesAEjecutar.size();
    }

}
