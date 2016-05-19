package com.ddsutn.group01.tpanual.models.origenes;
import java.util.ArrayList;
import com.ddsutn.group01.tpanual.models.CgpDTO.CentroDTO;
import com.ddsutn.group01.tpanual.models.CgpDTO.CgpAdapter;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

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