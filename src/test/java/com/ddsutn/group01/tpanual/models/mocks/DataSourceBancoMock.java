package com.ddsutn.group01.tpanual.models.mocks;

import com.ddsutn.group01.tpanual.dataSources.DataSourceBanco;

public class DataSourceBancoMock implements DataSourceBanco {
    @Override
    public String search(String criterio) {
        String resultados = "[ { \"banco\": \"Banco de la Plaza\", \"x\": -35.9338322, \"y\": 72.348353, \"sucursal\": \"Avellaneda\", \"gerente\": \"Javier Loeschbor\", \"servicios\": [ \"cobro cheques\", \"depósitos\", \"extracciones\", \"transferencias\", \"créditos\", \"\", \"\", \"\" ] } , { \"banco\": \"Banco de la Plaza\", \"x\": -35.9345681, \"y\": 72.344546, \"sucursal\": \"Caballito\", \"gerente\": \"Fabián Fantaguzzi\", \"servicios\": [ \"depósitos\", \"extracciones\", \"transferencias\", \"seguros\", \"\", \"\", \"\", \"\" ] } ] ";
        return resultados;
    }
}
