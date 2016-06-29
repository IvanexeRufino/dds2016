package com.ddsutn.group01.tpanual.Procesos;

import java.io.IOException;
import java.util.Date;

import com.ddsutn.group01.tpanual.Procesos.Excepciones.ExcepcionProceso;
import com.ddsutn.group01.tpanual.Procesos.Frecuencia.Frecuencia;

public abstract class Proceso {
    
    private Frecuencia tiempoDeEjecucion;
    private ExcepcionProceso tipoDeExcepcion;
    
    public void setFrecuencia(Frecuencia unaFrecuencia) {
        tiempoDeEjecucion = unaFrecuencia;
    }
    
    public void setTipoDeExcepcion(ExcepcionProceso tipo) {
        tipoDeExcepcion = tipo;
    }
    
    public abstract void ejecutar() throws IOException;
 
    public void activarProcesos (Date unHorario) throws Exception {
        Runnable task = () -> {
            try {
                this.ejecutar();
            } catch (Exception e) {
                try {
                    tipoDeExcepcion.manejarError(this,e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            };   
        tiempoDeEjecucion.activarProceso(task);
    }
}