package com.ddsutn.group01.tpanual.models.InterfazBancos;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

public class BancoAdapter {
    private Servicio servicio;
    
    public ArrayList<PointOfInterest> parsear(ArrayList<String> unaLista) {
        int i;
        ArrayList<PointOfInterest> puntosReales = new ArrayList<PointOfInterest>();
        ObjectMapper mapper = new ObjectMapper();
        //Si trataba de hacer el forEach en vez del for era imposible atrapar el error
        for(i=0;i<unaLista.size();i=i+1)
        try {
            BancoDTO cdb = mapper.readValue(unaLista.get(i), BancoDTO.class);
            SucursalBanco sucursal = cdb.modelarBanco();
            puntosReales.add(sucursal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return puntosReales;
    }
    
    public SucursalBanco modelarBanco(BancoDTO unBanco){
        ArrayList<Servicio> serviciosReales = new ArrayList<Servicio>();
        Point punto = new Point(unBanco.getX(),unBanco.getY());
        SucursalBanco sucursal = new SucursalBanco(unBanco.getId(), unBanco.getBanco(), punto);
        unBanco.getServicios().stream().forEach(nombre->serviciosReales.add(servicio = new Servicio(nombre,null)));
        sucursal.setServicios(serviciosReales);
        return sucursal;
    }
}
