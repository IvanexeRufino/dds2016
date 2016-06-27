package com.ddsutn.group01.tpanual.Procesos;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.ddsutn.group01.tpanual.InterpreterJSON.InterpreterJSON;
import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class BajaDePOIs {
    private DateTime tiempoDeEjecucion;
    private DataSourceBajaDePOIs dataSource;

    BajaDePOIs(DataSourceBajaDePOIs dataSource) {
        this.dataSource = dataSource;
    }
    
    public void setTeimpoDeEjecucion(DateTime unTiempo) {
        this.tiempoDeEjecucion = unTiempo;
    }
    
    public void ejecutar() {
        PoiRepository repositorio = PoiRepository.getInstance();
        String resultado = dataSource.bajaDePOIs();
        ArrayList<Integer> listaDePOIs = InterpreterJSON.getListaDePOIs(resultado);
        listaDePOIs.stream().map(numero->repositorio.getPOI(numero))
                            .forEach(poi->repositorio.remove(poi));
    }
}
