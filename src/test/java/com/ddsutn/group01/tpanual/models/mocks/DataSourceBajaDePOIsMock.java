package com.ddsutn.group01.tpanual.models.mocks;

import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;

public class DataSourceBajaDePOIsMock implements DataSourceBajaDePOIs {

    @Override
    public String bajaDePOIs() {
        return ("{ \"puntos\": [ 1, 2], \"fecha\": \"2016/3/29\" }");
    }

}
