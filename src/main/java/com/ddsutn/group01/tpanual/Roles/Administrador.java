package com.ddsutn.group01.tpanual.Roles;

import java.util.ArrayList;
import java.util.List;

import com.ddsutn.group01.tpanual.Procesos.Proceso;

public class Administrador {
    private List<Proceso> listaDeProcesos = new ArrayList<Proceso>();
    private List<Terminal> terminales = new ArrayList<Terminal>();
    
    public void agregarProceso(Proceso unProceso) {
        listaDeProcesos.add(unProceso);
    }
    
    public void agregarTerminal(Terminal unaTerminal) {
        terminales.add(unaTerminal);
    }
    
}