package com.ddsutn.group01.tpanual.procesos.Excepciones;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ddsutn.group01.tpanual.Procesos.BajaDePOIs;
import com.ddsutn.group01.tpanual.Procesos.Excepciones.ExcepcionIntentos;
import com.ddsutn.group01.tpanual.Procesos.Excepciones.ExcepcionVacia;
import com.ddsutn.group01.tpanual.Procesos.Frecuencia.Unico;
import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;

public class ExceptionIntentosVacioTest {

    private CountDownLatch lock = new CountDownLatch(1);
    private BajaDePOIs proceso;
    private ExcepcionIntentos intentos;
    private ExcepcionVacia vacia;
    private DataSourceBajaDePOIs dataSource;
    private Unico frecuenciaUnica;
    private Date dia;
    
    @Before
    public void init() throws InterruptedException {
        vacia = new ExcepcionVacia();
        dia = new Date();
        frecuenciaUnica = new Unico(dia);
        intentos = new ExcepcionIntentos(3, vacia);
        proceso = new BajaDePOIs(dataSource);
        proceso.setTipoDeExcepcion(intentos);
        proceso.setFrecuencia(frecuenciaUnica);
        proceso.activarProcesos();
        lock.await(2000, TimeUnit.MILLISECONDS);
    }
    
    @Test
    public void LuegoDeTresIntentosMarcaElProcesoComoFallado() {
        Assert.assertEquals("Error", proceso.getEstado());
    }
    
}
