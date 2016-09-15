package com.ddsutn.group01.tpanual.Procesos;


import java.util.List;

import com.ddsutn.group01.tpanual.InterpreterJSON.InterpreterJSON;
import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class BajaDePOIs extends Proceso{
    private DataSourceBajaDePOIs dataSource;

    public BajaDePOIs(DataSourceBajaDePOIs dataSource) {
        this.dataSource = dataSource;
    }

    public int ejecutar() throws Exception{
        String resultado = dataSource.bajaDePOIs();
        List<Integer> listaDePOIs = InterpreterJSON.getListaDePOIs(resultado);
        listaDePOIs.forEach(PoiRepository.getInstance()::remove);

        return listaDePOIs.size();
    }
}
