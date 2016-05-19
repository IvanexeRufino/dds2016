package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.util.ArrayList;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Servicio;

public class ServicioDTO {
	
	    private String nombre;
		private ArrayList<DiasDeServicio> listaDeDias = new ArrayList<DiasDeServicio>();
		
		public ServicioDTO(String nombre, ArrayList<DiasDeServicio> listaDeDias) {
			super();
			this.nombre = nombre;
			this.listaDeDias = listaDeDias;
		}

		public Servicio modelar(){
		    HorariosDeAtencion unosHorarios = new HorariosDeAtencion();
		    listaDeDias.forEach(unHorario->unosHorarios.agregarHorario(unHorario.modelar()));
		    Servicio unServicio = new Servicio(nombre, unosHorarios);
		    return unServicio;
		}
}

