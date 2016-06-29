package com.ddsutn.group01.tpanual.models.mocks;

import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;

public class DataSourceBajaDePOIsMock implements DataSourceBajaDePOIs {

    @Override
    public String bajaDePOIs() {
        String resultados = ("{ \"puntos\": [ 1, 2, 3, 4, 5], \"fecha\": \"hoy\" }");
        return resultados;
    }

}
