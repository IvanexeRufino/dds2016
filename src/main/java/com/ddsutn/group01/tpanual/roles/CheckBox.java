package com.ddsutn.group01.tpanual.roles;

import javax.persistence.Entity;

import com.ddsutn.group01.tpanual.db.PersistentRecord;

@Entity
public class CheckBox extends PersistentRecord{
	
	
	private Boolean state;
	
	private int posicion;
	
	
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	public CheckBox() {
		state = false;
	}
	 

}
