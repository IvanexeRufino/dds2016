package com.ddsutn.group01.tpanual.models.InterfazBancos;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

public class ParserBancos {
    public ArrayList<PointOfInterest> parsear(ArrayList<String> unaLista) {
        int i;
        ArrayList<PointOfInterest> puntosReales = new ArrayList<PointOfInterest>();
        ObjectMapper mapper = new ObjectMapper();
        //Si trataba de hacer el forEach en vez del for era imposible atrapar el error
        for(i=0;i<unaLista.size();i=i+1)
        try {
            CreadorDeBancos cdb = mapper.readValue(unaLista.get(i), CreadorDeBancos.class);
            SucursalBanco sucursal = cdb.modelarBanco();
            puntosReales.add(sucursal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return puntosReales;
    }
}
