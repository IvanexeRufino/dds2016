package com.ddsutn.group01.tpanual.adapters.Banco;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BancoAdapterTest {

    @Test
    public void adapt() throws Exception {
        ArrayList<String> unaLista = new ArrayList<>();
        String JSON1 = "{\"banco\":\"Banco de la Plaza\",\"x\":-35,\"y\":72,\"sucursal\":\"Caballito\",\"gerente\":\"Fabian\",\"servicios\":[\"depositos\",\"extracciones\"]}";
        String JSON2 = "{\"x\":-36,\"y\":73,\"servicios\":[\"depositos\",\"extracciones\"],\"banco\":\"Banco de la plaza\",\"sucursal\":\"Avellaneda\",\"gerente\":\"Juancito\"}";
        unaLista.add(JSON1);
        unaLista.add(JSON2);
        ArrayList<PointOfInterest> listaReal = BancoAdapter.adapt(unaLista);
        Assert.assertTrue(listaReal.size() == 2);
    }
}
