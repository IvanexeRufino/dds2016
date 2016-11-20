package com.ddsutn.group01.tpanual.roles;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.actions.Action;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Terminal extends User{
	
    @Column
    private int comuna;

    @Column(length = 25)
    private String nombreDeTerminal;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Action> actions;

    @Transient
    private Buscador buscador;
    
    private CheckBox mail;
    
    private CheckBox report;
    
    private CheckBox metrics;
    
    private CheckBox terminal;
    
	public CheckBox getMail() {
		return mail;
	}

	public void setMail(CheckBox mail) {
		this.mail = mail;
	}

	public CheckBox getReport() {
		return report;
	}

	public void setReport(CheckBox report) {
		this.report = report;
	}

	public CheckBox getMetrics() {
		return metrics;
	}

	public void setMetrics(CheckBox metrics) {
		this.metrics = metrics;
	}

	public CheckBox getTerminal() {
		return terminal;
	}

	public void setTerminal(CheckBox terminal) {
		this.terminal = terminal;
	}

	@SuppressWarnings("unused")
	public Terminal() {}

    public Terminal(String nombreDeTerminal, Integer unaComuna, Buscador unBuscador) {
        this.comuna = unaComuna;
        this.nombreDeTerminal = nombreDeTerminal;
        this.buscador = unBuscador;
        this.actions = new ArrayList<>();
        this.mail = new CheckBox();
        this.report = new CheckBox();
        this.metrics = new CheckBox();
        this.terminal = new CheckBox();
    }

	public void setComuna(int comuna) {
		this.comuna = comuna;
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
    
    public void setNombreDeTerminal(String nombre) {
        this.nombreDeTerminal = nombre;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    public List<PointOfInterest> find(String searchText) {
        actions.forEach(Action::precondition);
        List<PointOfInterest> resultados = buscador.find(searchText);
        actions.forEach(action -> action.postcondition(searchText, resultados.size(), nombreDeTerminal));

        return resultados;
    }
    
}
