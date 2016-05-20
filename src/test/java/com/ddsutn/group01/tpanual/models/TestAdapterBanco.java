package com.ddsutn.group01.tpanual.models;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.ddsutn.group01.tpanual.models.InterfazBancos.BancoAdapter;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

public class TestAdapterBanco {

    private BancoAdapter adaptador = new BancoAdapter();

    @Test
    public void testAdaptarElArrayConStringsJSONEnObjetosSucursalBanco(){
        ArrayList<String> unaLista = new ArrayList<String>();
        String objetoJSON = "{\"banco\":\"Banco de la Plaza\",\"x\":-35,\"y\":72,\"sucursal\":\"Caballito\",\"gerente\":\"Fabian\",\"servicios\":[\"depositos\",\"extracciones\"]}";
        String objetoJSON2 = "{\"x\":-36,\"y\":73,\"servicios\":[\"depositos\",\"extracciones\"],\"banco\":\"Banco de la plaza\",\"sucursal\":\"Avellaneda\",\"gerente\":\"Juancito\"}";
        unaLista.add(objetoJSON);
        unaLista.add(objetoJSON2);
        ArrayList<PointOfInterest> listaReal = adaptador.parsear(unaLista);
        Assert.assertTrue(listaReal.size()==2);
    }
}
