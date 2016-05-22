package com.ddsutn.group01.tpanual.models.mocks;

import com.ddsutn.group01.tpanual.externalSources.ExternalSourceBanco;

import java.util.ArrayList;

public class ExternalSourceBancoMock implements ExternalSourceBanco {
    @Override
    public ArrayList<String> search(String criterio) {
        ArrayList<String> resultados = new ArrayList<String>();
        resultados.add("{ \"banco\": \"Banco de la Plaza\", \"x\": -35.9338322, \"y\": 72.348353, \"sucursal\": \"Avellaneda\", \"gerente\": \"Javier Loeschbor\", \"servicios\": [ \"cobro cheques\", \"depósitos\", \"extracciones\", \"transferencias\", \"créditos\", \"\", \"\", \"\" ] }");
        resultados.add("{ \"banco\": \"Banco de la Plaza\", \"x\": -35.9345681, \"y\": 72.344546, \"sucursal\": \"Caballito\", \"gerente\": \"Fabián Fantaguzzi\", \"servicios\": [ \"depósitos\", \"extracciones\", \"transferencias\", \"seguros\", \"\", \"\", \"\", \"\" ] }");
        return resultados;
    }
}
