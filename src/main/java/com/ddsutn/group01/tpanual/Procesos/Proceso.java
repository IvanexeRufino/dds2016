package com.ddsutn.group01.tpanual.Procesos;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTime;

import com.ddsutn.group01.tpanual.Procesos.Excepciones.ExcepcionProceso;
import com.ddsutn.group01.tpanual.Procesos.Frecuencia.Frecuencia;
import com.ddsutn.group01.tpanual.Procesos.Log.Log;

public abstract class Proceso {
    
    private Frecuencia tiempoDeEjecucion;
    private ExcepcionProceso tipoDeExcepcion;
    private String estado = "No ejecutandose";
    private Log log = new Log();
    
    public void setFrecuencia(Frecuencia unaFrecuencia) {
        tiempoDeEjecucion = unaFrecuencia;
    }
    
    public void setTipoDeExcepcion(ExcepcionProceso tipo) {
        tipoDeExcepcion = tipo;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void ejecutarProceso() throws IOException {
        this.setEstado("EnEjecucion");
        int cantidadDeResultados = this.ejecutar();
        this.setEstado("Finalizado");
        this.log.guardar(cantidadDeResultados,DateTime.now(), estado);
    }
    
    public abstract int ejecutar() throws IOException;
 
    public void activarProcesos (Date unHorario) throws Exception {
        Runnable task = () -> {
            try {
                this.ejecutarProceso();
            } catch (Exception e) {
                try {
                    tipoDeExcepcion.manejarError(this);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            };   
        tiempoDeEjecucion.activarProceso(task);
    }
    
    
}