package com.ddsutn.group01.tpanual.adapters.Banco;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class BancoAdapter {
    static public ArrayList<PointOfInterest> adapt(ArrayList<String> unaLista) {
        ArrayList<PointOfInterest> puntosReales = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        //Si trataba de hacer el forEach en vez del for era imposible atrapar el error
        for (int i = 0; i < unaLista.size(); i++) {
            try {
                CreadorDeBancos cdb = mapper.readValue(unaLista.get(i), CreadorDeBancos.class);
                SucursalBanco sucursal = cdb.modelarBanco();
                puntosReales.add(sucursal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return puntosReales;
    }
}
