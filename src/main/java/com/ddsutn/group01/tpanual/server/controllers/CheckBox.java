package com.ddsutn.group01.tpanual.server.controllers;

public class CheckBox {

	private String username;
	
	private boolean state;
	
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CheckBox(String username, String name, boolean state) {
		this.username = username;
		this.nombre = name;
		this.state = state;
	}

}
