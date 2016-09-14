package com.ddsutn.group01.tpanual.Roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.repositories.actions.Action;

@Entity
public class Terminal {
	
	@Id @GeneratedValue
	private long id;
    private int comuna;
	@Column (length = 25)
    private String nombreDeTerminal;
	//todavia pienso en si puede ser un many to many
	@OneToMany
    private List<Action> actions;
	@OneToOne(fetch = FetchType.LAZY)
    private Buscador buscador;

    public Terminal(String nombreDeTerminal, Integer unaComuna, Buscador unBuscador) {
        this.comuna = unaComuna;
        this.nombreDeTerminal = nombreDeTerminal;
        this.buscador = unBuscador;
        this.actions = new ArrayList<>();
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
        actions.forEach(action -> action.postcondition(criteria, lista.size(),nombreDeTerminal));
        return lista;
    }
}
