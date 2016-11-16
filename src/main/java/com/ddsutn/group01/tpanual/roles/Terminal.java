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
    
    private int mail;
    private int repo;
    private int sm;
    private int rt;
    
    

    public int getMail() {
		return mail;
	}



	public void setMail(int mail) {
		this.mail = mail;
	}



	public int getRepo() {
		return repo;
	}



	public void setRepo(int repo) {
		this.repo = repo;
	}



	public int getSm() {
		return sm;
	}



	public void setSm(int sm) {
		this.sm = sm;
	}



	public int getRt() {
		return rt;
	}



	public void setRt(int rt) {
		this.rt = rt;
	}



	@SuppressWarnings("unused")
	public Terminal() {}
    
    

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

    public List<PointOfInterest> find(String searchText) {
        actions.forEach(Action::precondition);
        List<PointOfInterest> resultados = buscador.find(searchText);
        actions.forEach(action -> action.postcondition(searchText, resultados.size(), nombreDeTerminal));

        return resultados;
    }
}
