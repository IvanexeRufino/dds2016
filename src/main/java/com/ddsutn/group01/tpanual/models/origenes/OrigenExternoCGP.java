package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.CgpDTO.CentroDTO;
import com.ddsutn.group01.tpanual.models.CgpDTO.CgpAdapter;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;

public class OrigenExternoCGP extends OrigenExterno{
    private DataSourceCGP dataSource;
    private CgpAdapter parser;

    public void setDataSource(DataSourceCGP dataSoruce) {
        this.dataSource = dataSoruce;
        parser = new CgpAdapter();
    }

    @Override
    public ArrayList<PointOfInterest> buscar(String unaPalabra) {
        ArrayList<CentroDTO> centros = dataSource.buscar(unaPalabra);
        return parser.parsear(centros);
    }
}
