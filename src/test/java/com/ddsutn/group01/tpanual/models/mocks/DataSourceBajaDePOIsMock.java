package com.ddsutn.group01.tpanual.models.mocks;

import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;

public class DataSourceBajaDePOIsMock implements DataSourceBajaDePOIs {

    private int id1;
    private int id2;

    public DataSourceBajaDePOIsMock(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public String bajaDePOIs() {
        return ("{ \"puntos\": [ " + Integer.toString(id1) + ", " + Integer.toString(id2) + "], \"fecha\": \"2016/3/29\" }");
    }

}
