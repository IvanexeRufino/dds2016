package com.ddsutn.group01.tpanual.Procesos;

import java.io.IOException;
import java.util.Date;

import com.ddsutn.group01.tpanual.Procesos.Frecuencia.Frecuencia;

public abstract class Proceso {
    
    private Frecuencia tiempoDeEjecucion;
    
    public void setFrecuencia(Frecuencia unaFrecuencia) {
        tiempoDeEjecucion = unaFrecuencia;
    }
    
    protected abstract void ejecutar() throws IOException;
 
    public void activarProcesos (Date unHorario) throws InterruptedException {
        Runnable task = () -> {
            try {
                this.ejecutar();
            } catch (Exception e) {
                e.printStackTrace();
            }
            };   
        tiempoDeEjecucion.activarProceso(task);
    }
}