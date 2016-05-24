package com.ddsutn.group01.tpanual.adapters.Banco;

import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

import org.codehaus.jackson.map.ObjectMapper;
import org.uqbar.geodds.Point;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BancoAdapter {
    static Servicio servicio;
    static BancoDTO unBanco;
    
    static public ArrayList<PointOfInterest> adapt(ArrayList<String> unaLista) {
        ArrayList<PointOfInterest> puntosReales = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        //Si trataba de hacer el forEach en vez del for era imposible atrapar el error
        for (int i = 0; i < unaLista.size(); i++) {
            try {
                BancoDTO unDTO = mapper.readValue(unaLista.get(i), BancoDTO.class);
                SucursalBanco sucursal = modelarBanco(unDTO);
                puntosReales.add(sucursal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return puntosReales;
    }
    
    static public SucursalBanco modelarBanco(BancoDTO unBanco) {
        Point punto = new Point(unBanco.getX(),unBanco.getY());
        SucursalBanco sucursal = new SucursalBanco(unBanco.getId(), unBanco.getBanco(), punto);
        sucursal.setServicios(unBanco.getServicios().stream().map(nombre->servicio = new Servicio(nombre,null))
                                                             .collect(Collectors.toList()));
        return sucursal;
    }
}