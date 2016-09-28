package com.ddsutn.group01.tpanual.adapters.Banco;

import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import java.util.List;

public class BancoAdapterTest {
    private List<PointOfInterest> listaReal;
    private SucursalBanco sucursalPosta;

    @Before
    public void init() {
        String JSON1 = "[{\"banco\":\"Banco de la Plaza\",\"x\":-35,\"y\":72,\"sucursal\":\"Caballito\",\"gerente\":\"Fabian\",\"servicios\":[\"depositos\",\"extracciones\"]} , {\"x\":-36,\"y\":73,\"servicios\":[\"depositos\",\"extracciones\"],\"banco\":\"Banco de la Plaza\",\"sucursal\":\"Avellaneda\",\"gerente\":\"Juancito\"} ]";
        listaReal = BancoAdapter.adapt(JSON1);
    }

    @Test
    public void adaptarJSON1esIgualAUnaSucursalDeBancoDeNuestroDominio() {
      SucursalBanco unaSucursal = (SucursalBanco) listaReal.get(0);
      Point punto = new Point(30,50);
      sucursalPosta = new SucursalBanco("Banco de la Plaza",  new Point(-35, 72));
      Servicio depositos = new Servicio("depositos",null);
      Servicio extracciones = new Servicio("extracciones",null);
      sucursalPosta.agregarUnServicio(depositos);
      sucursalPosta.agregarUnServicio(extracciones);

      Assert.assertEquals(unaSucursal.getName(), sucursalPosta.getName());
      Assert.assertTrue(unaSucursal.getPoint().distance(punto) == sucursalPosta.getPoint().distance(punto));
      Assert.assertEquals(unaSucursal.getServicios().get(1).getNombre(), sucursalPosta.getServicios().get(1).getNombre());
      Assert.assertEquals(unaSucursal.getServicios().get(2).getNombre(), sucursalPosta.getServicios().get(2).getNombre());
      }

    @Test
    public void adaptarJSON2NoImportaElOrden() {
        SucursalBanco unaSucursal = (SucursalBanco) listaReal.get(1);
        Point punto = new Point(30,50);
        sucursalPosta = new SucursalBanco("Banco de la Plaza",  new Point(-36, 73));
        Servicio depositos = new Servicio("depositos",null);
        Servicio extracciones = new Servicio("extracciones",null);
        sucursalPosta.agregarUnServicio(depositos);
        sucursalPosta.agregarUnServicio(extracciones);

        Assert.assertEquals(unaSucursal.getName(), sucursalPosta.getName());
        Assert.assertTrue(unaSucursal.getPoint().distance(punto) == sucursalPosta.getPoint().distance(punto));
        Assert.assertEquals(unaSucursal.getServicios().get(1).getNombre(), sucursalPosta.getServicios().get(1).getNombre());
        Assert.assertEquals(unaSucursal.getServicios().get(2).getNombre(), sucursalPosta.getServicios().get(2).getNombre());
    }

    @Test (expected = RuntimeException.class)
    public void adaptarLanzaExcepcionSiEstaMalFormadoElString() {
        String JSONerror = "hola como te va";
        BancoAdapter.adapt(JSONerror);
    }

}
