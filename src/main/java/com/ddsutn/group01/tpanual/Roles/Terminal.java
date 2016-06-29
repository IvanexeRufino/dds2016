package com.ddsutn.group01.tpanual.Roles;

import java.util.ArrayList;
import java.util.List;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.repositories.actions.Action;

public class Terminal {
    private int comuna;
    private String nombreDeTerminal;
    private List<Action> actions = new ArrayList<>();
    private Buscador buscador;
       
    public Terminal(String nombreDeTerminal, Integer unaComuna, Buscador unBuscador) {
        this.comuna = unaComuna;
        this.nombreDeTerminal = nombreDeTerminal; 
        this.buscador = unBuscador;
    }
    
    public int getComuna() {
        return comuna;
    }
    
    public List<Action> getAcciones() {
        return actions;
    }
    
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
    
    public String getNombreDeTerminal() {
        return nombreDeTerminal;
    }
    
    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }
    
    public List<PointOfInterest> find(String criteria) {
        actions.forEach(Action::precondition);
        List<PointOfInterest> lista =  buscador.find(criteria);
        actions.forEach(action -> action.postcondition(criteria, lista));
        return lista;
    }
    
}