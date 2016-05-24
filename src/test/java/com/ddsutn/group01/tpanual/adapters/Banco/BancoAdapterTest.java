package com.ddsutn.group01.tpanual.adapters.Banco;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import java.util.ArrayList;

public class BancoAdapterTest {
    private ArrayList<PointOfInterest> listaReal;
    
    @Before
    public void init() {
        ArrayList<String> unaLista = new ArrayList<>();
        String JSON1 = "{\"banco\":\"Banco de la Plaza\",\"x\":-35,\"y\":72,\"sucursal\":\"Caballito\",\"gerente\":\"Fabian\",\"servicios\":[\"depositos\",\"extracciones\"]}";
        String JSON2 = "{\"x\":-36,\"y\":73,\"servicios\":[\"depositos\",\"extracciones\"],\"banco\":\"Banco de la plaza\",\"sucursal\":\"Avellaneda\",\"gerente\":\"Juancito\"}";
        unaLista.add(JSON1);
        unaLista.add(JSON2);
        listaReal = BancoAdapter.adapt(unaLista);
    }

    @Test
    public void adaptarJSON1estaCercaDelPunto() {
        Point unPunto = new Point(-35,72.005);
        PointOfInterest unaSucursal = listaReal.get(0);
        Assert.assertTrue(unaSucursal.estaCercaDe(unPunto));
    }
    
    @Test
    public void adaptarJSON2PalabraEstaDepositos() {
        PointOfInterest unaSucursal = listaReal.get(1);
        Assert.assertTrue(unaSucursal.palabraEsta("depositos"));
    }
}
