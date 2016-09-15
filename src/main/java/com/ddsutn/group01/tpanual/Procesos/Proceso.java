package com.ddsutn.group01.tpanual.Procesos;

import org.joda.time.DateTime;

import com.ddsutn.group01.tpanual.Procesos.Excepciones.ExcepcionProceso;
import com.ddsutn.group01.tpanual.Procesos.Frecuencia.Frecuencia;
import com.ddsutn.group01.tpanual.Procesos.Log.Log;

public abstract class Proceso {
    
    private Frecuencia tiempoDeEjecucion;
    private ExcepcionProceso tipoDeExcepcion;
    private String estado;
    private Log log = new Log();
    
    public void setFrecuencia(Frecuencia unaFrecuencia) {
        tiempoDeEjecucion = unaFrecuencia;
    }
    
    public void setTipoDeExcepcion(ExcepcionProceso tipo) {
        tipoDeExcepcion = tipo;
    }
    
    public void estadoTerminado() {
        this.estado = "Terminado";
    }
    
    public void estadoError() {
    	this.estado = "Error";
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void ejecutarProceso() throws Exception {
        int cantidadDeResultados = this.ejecutar();
        this.estadoTerminado();
        this.log.guardar(cantidadDeResultados,DateTime.now(), estado);
    }
    
    public abstract int ejecutar() throws Exception;
 
    public void activarProcesos() {
        Runnable task = () -> {
            try {
                this.ejecutarProceso();
            } catch (Exception e) {
                    tipoDeExcepcion.manejarError(this);
                }
            };   
        tiempoDeEjecucion.activarProceso(task);
    }
    
}