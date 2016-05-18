package com.ddsutn.group01.tpanual.models;

import com.ddsutn.group01.tpanual.models.origenes.OrigenDatos;
import com.ddsutn.group01.tpanual.models.origenes.OrigenExterno;
import com.ddsutn.group01.tpanual.models.origenes.OrigenLocal;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;

public class PoiDAO {
    private static PoiDAO instancia = null;
    private ArrayList<OrigenDatos> origenesExternos;
    private OrigenLocal origenLocal;


	private PoiDAO() {
		origenesExternos = new ArrayList<>();
        origenLocal = new OrigenLocal();
	}
	
	public void agregarOrigenExterno(OrigenExterno unOrigen){
	    origenesExternos.add(unOrigen);
	}

    public static PoiDAO getInstance() {
        if (instancia == null){
            instancia = new PoiDAO();
        }

        return instancia;
    }

    public void crear(PointOfInterest poi) {
    	origenLocal.crear(poi);
    }

    public void editar(PointOfInterest poi) {
        origenLocal.editar(poi);
    }

    public void eliminar(PointOfInterest poi){
        origenLocal.eliminar(poi);
    }

    public ArrayList<PointOfInterest> buscar(String criterio){
        ArrayList<PointOfInterest> listaDePuntos = new ArrayList<PointOfInterest>();
        listaDePuntos.addAll(origenLocal.buscar(criterio));
        //agregar la busqueda de origenes externos
        return listaDePuntos;
    }
}
