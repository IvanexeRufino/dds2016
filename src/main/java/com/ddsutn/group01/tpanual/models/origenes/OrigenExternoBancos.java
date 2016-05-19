package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.InterfazBancos.ParserBancos;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;

public class OrigenExternoBancos extends OrigenExterno {
    private DataSourceBancos dataSource;
    private ParserBancos parser;

    public void setDataSource(DataSourceBancos dataSoruce) {
        this.dataSource = dataSoruce;
        parser = new ParserBancos();
    }
    
    @Override
    public ArrayList<PointOfInterest> buscar(String unaPalabra) {
        ArrayList<String> json = dataSource.buscar(unaPalabra);
        return parser.parsear(json);
    }
}