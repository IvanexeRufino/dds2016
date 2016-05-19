package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.InterfazBancos.ParserBancos;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

public class OrigenExternoBancos implements OrigenDatos {
    private DataSource dataSoruce;

    public void setDataSource(DataSource dataSoruce) {
        this.dataSoruce = dataSoruce;
    }

    @Override
    public void agregar(PointOfInterest poi) { }

    @Override
    public void editar(PointOfInterest poi) { }

    @Override
    public void eliminar(PointOfInterest poi) { }

    @Override
    public List<PointOfInterest> buscar(String unaPalabra) {
        ArrayList<String> json = dataSoruce.buscar(unaPalabra);
        ParserBancos parserBancos = new ParserBancos();
        return parserBancos.parsear(json);
    }
}
