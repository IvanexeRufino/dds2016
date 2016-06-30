package com.ddsutn.group01.tpanual.procesos.Excepciones;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ddsutn.group01.tpanual.Procesos.BajaDePOIs;
import com.ddsutn.group01.tpanual.Procesos.Excepciones.ExcepcionIntentos;
import com.ddsutn.group01.tpanual.Procesos.Excepciones.ExcepcionMail;
import com.ddsutn.group01.tpanual.Procesos.Frecuencia.Unico;
import com.ddsutn.group01.tpanual.dataSources.DataSourceBajaDePOIs;
import com.ddsutn.group01.tpanual.tools.mailers.Mailer;

public class ExcepcionIteracionMailTest {

    private Mailer mockedMailer;
    private CountDownLatch lock = new CountDownLatch(1);
    private BajaDePOIs proceso;
    private ExcepcionIntentos intentos;
    private ExcepcionMail mail;
    private DataSourceBajaDePOIs dataSource;
    private Unico frecuenciaUnica;
    private Date dia;
    
    @Before
    public void init() throws InterruptedException {
        mockedMailer = Mockito.spy(new Mailer() {
            @Override
            public void send(String to, String subject, String content) throws Exception { }
        });
        mail = new ExcepcionMail(mockedMailer);
        dia = new Date();
        frecuenciaUnica = new Unico(dia);
        intentos = new ExcepcionIntentos(3, mail);
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
    
    @Test
    public void LuegoDeTresIntentosMandaUnMail() throws Exception {
        verify(mockedMailer).send(any(String.class), any(String.class), any(String.class));
    }
    
}
