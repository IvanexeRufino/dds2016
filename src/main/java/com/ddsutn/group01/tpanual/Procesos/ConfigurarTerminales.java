package com.ddsutn.group01.tpanual.Procesos;

import java.util.List;
import java.util.stream.Collectors;

import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.repositories.actions.Action;

public class ConfigurarTerminales {
    private List<Action> acciones;
    private List<Terminal> terminales;
    private List<Terminal> terminalesAEjecutar;
    
    
    
    public ConfigurarTerminales(List<Terminal> terminales) {
        this.terminales = terminales;
        this.terminalesAEjecutar = terminales;
    }
    
    public void setAcciones(List<Action> acciones) {
        this.acciones = acciones;
    }
    
    public void configurarTerminalesPorComuna(int comuna) {
        terminalesAEjecutar = terminales.stream().filter(terminal->terminal.getComuna() == comuna)
                                                 .collect(Collectors.toList());
    }
    
    public void configurarTodasLasTerminales() {
        terminalesAEjecutar = terminales;
    }
    
    public void configurarTerminal(Terminal unaTerminal) {
        terminalesAEjecutar = terminales.stream().filter(terminal->terminal.getNombreDeTerminal() == unaTerminal.getNombreDeTerminal())
                                                 .collect(Collectors.toList());
    }
    
    public void ejecutar() {
        terminalesAEjecutar.forEach(terminales->terminales.setActions(acciones));
    }
    
}