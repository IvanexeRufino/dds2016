package com.ddsutn.group01.tpanual.models;

import com.ddsutn.group01.tpanual.models.origenes.OrigenDatos;
import com.ddsutn.group01.tpanual.models.origenes.OrigenExterno;
import com.ddsutn.group01.tpanual.models.origenes.OrigenLocal;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

public class PoiDAO {
    private static PoiDAO instancia = null;
    private List<OrigenDatos> origenes;


	private PoiDAO() {
		origenes = new ArrayList<>();
        origenes.add(new OrigenLocal());
        origenes.add(new OrigenExterno());
        origenes.add(new OrigenExterno());
	}

    public static PoiDAO getInstance() {
        if (instancia == null){
            instancia = new PoiDAO();
        }

        return instancia;
    }

    public void crear(PointOfInterest poi) {
    	origenes.stream().forEach((origen) -> origen.agregar(poi));
    }

    public void editar(PointOfInterest poi) {
        origenes.stream().forEach((origen) -> origen.editar(poi));
    }

    public void eliminar(PointOfInterest poi){
        origenes.stream().forEach((origen) -> origen.eliminar(poi));
    }

    public List<PointOfInterest> buscar(String criterio){
        //  origenes.stream().map((origen) -> origen.buscar(criterio)).collect(Collectors.toList());
        return null;
    }
}
