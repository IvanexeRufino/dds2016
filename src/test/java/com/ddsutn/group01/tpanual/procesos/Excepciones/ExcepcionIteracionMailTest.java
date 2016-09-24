package com.ddsutn.group01.tpanual.procesos.Excepciones;

import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;
import com.ddsutn.group01.tpanual.procesos.BajaDePOIs;
import com.ddsutn.group01.tpanual.procesos.Frecuencia.Unico;
import com.ddsutn.group01.tpanual.tools.mailers.Mailer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class ExcepcionIteracionMailTest {

    private Mailer mockedMailer;
    private CountDownLatch lock = new CountDownLatch(1);
    private BajaDePOIs proceso;

    @Before
    public void init() throws InterruptedException {
        mockedMailer = Mockito.mock(Mailer.class);

        ExcepcionMail excepcionMail = new ExcepcionMail(mockedMailer);
        Date dia = new Date();
        Unico frecuenciaUnica = new Unico(dia);
        ExcepcionIntentos intentos = new ExcepcionIntentos(1, excepcionMail);

        proceso = new BajaDePOIs(Mockito.mock(DataSourceBajaDePOIs.class));
        proceso.setTipoDeExcepcion(intentos);
        proceso.setFrecuencia(frecuenciaUnica);
        proceso.activarProcesos();
        lock.await(1000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void LuegoDeTresIntentosMarcaElProcesoComoFallado() {
        Assert.assertEquals("Error", proceso.getEstado());
    }

    @Test
    public void LuegoDeTresIntentosMandaUnMail() throws Exception {
        verify(mockedMailer).send(any(String.class), any(String.class), any(String.class));
    }

}
