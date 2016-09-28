package com.ddsutn.group01.tpanual.adapters.Banco;

import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import org.uqbar.geodds.Point;

import java.util.List;
import java.util.stream.Collectors;

public class BancoAdapter {
    static Servicio servicio;

    static public List<PointOfInterest> adapt(List<String> unaLista) {
        return unaLista.stream()
            .map(MapperDeBancos::mappear)
            .map(BancoAdapter::modelarBanco)
            .collect(Collectors.toList());
    }

    static public PointOfInterest modelarBanco(BancoDTO unBanco) {
        Point punto = new Point(unBanco.getX(), unBanco.getY());
        SucursalBanco sucursal = new SucursalBanco(unBanco.getBanco(), punto);
        unBanco.getServicios().stream().map(nombre -> servicio = new Servicio(nombre, null))
            .forEach(sucursal::agregarUnServicio);
        return sucursal;
    }
}
