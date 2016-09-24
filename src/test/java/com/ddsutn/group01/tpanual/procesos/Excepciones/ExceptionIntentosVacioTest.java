package com.ddsutn.group01.tpanual.procesos.Excepciones;

import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;
import com.ddsutn.group01.tpanual.procesos.BajaDePOIs;
import com.ddsutn.group01.tpanual.procesos.Frecuencia.Unico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ExceptionIntentosVacioTest {

    private CountDownLatch lock = new CountDownLatch(1);
    private BajaDePOIs proceso;

    @Before
    public void init() throws InterruptedException {
        ExcepcionVacia vacia = new ExcepcionVacia();
        Date dia = new Date();
        Unico frecuenciaUnica = new Unico(dia);
        ExcepcionIntentos intentos = new ExcepcionIntentos(1, vacia);

        proceso = new BajaDePOIs(Mockito.mock(DataSourceBajaDePOIs.class));
        proceso.setTipoDeExcepcion(intentos);
        proceso.setFrecuencia(frecuenciaUnica);
        proceso.activarProcesos();
        lock.await(1000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void luegoDeUnIntentoMarcaElProcesoComoFallado() {
        Assert.assertEquals("Error", proceso.getEstado());
    }

}
