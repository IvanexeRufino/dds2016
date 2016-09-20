package com.ddsutn.group01.tpanual.Roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.ddsutn.group01.tpanual.PersistentRecord;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.repositories.actions.Action;

@Entity
public class Terminal extends PersistentRecord{
	
    private int comuna;
	@Column (length = 25)
    private String nombreDeTerminal;
	@OneToMany
    private List<Action> actions;
	@Transient
    private Buscador buscador;

	@SuppressWarnings("unused")
	private Terminal() {}
	
    public Terminal(String nombreDeTerminal, Integer unaComuna, Buscador unBuscador) {
        this.comuna = unaComuna;
        this.nombreDeTerminal = nombreDeTerminal;
        this.buscador = unBuscador;
        this.actions = new ArrayList<>();
    }

    public int getComuna() {
        return comuna;
    }

    public Buscador getBuscador() {
    	return buscador;
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
        actions.forEach(action -> action.postcondition(criteria, lista.size(),nombreDeTerminal));
        return lista;
    }
}
