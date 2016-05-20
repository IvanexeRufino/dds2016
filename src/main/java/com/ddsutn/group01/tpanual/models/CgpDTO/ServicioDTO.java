package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.util.ArrayList;

public class ServicioDTO {
    private String nombre;
    private ArrayList<DiasDeServicio> listaDeDias = new ArrayList<DiasDeServicio>();

	public ServicioDTO(String nombre, ArrayList<DiasDeServicio> listaDeDias) {
		this.nombre = nombre;
		this.listaDeDias = listaDeDias;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<DiasDeServicio> getListaDeDias() {
        return listaDeDias;
    }

    public void setListaDeDias(ArrayList<DiasDeServicio> listaDeDias) {
        this.listaDeDias = listaDeDias;
    }
}
