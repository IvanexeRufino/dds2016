package com.ddsutn.group01.tpanual.terminal;

import java.util.ArrayList;

public class Terminal {
	private String usuario;
	private ArrayList <Accion> acciones;

	public Terminal(String usuario) {
		this.usuario = usuario;
		this.acciones = new ArrayList<>();
	}
	
	public void agregarAcciones (Accion unaAccion) {
		acciones.add(unaAccion);
	}
	
	public void quitarAcciones (Accion unaAccion) {
		acciones.remove(unaAccion);
	}	
	
}

