package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.procesos.Excepciones.ExcepcionProceso;
import com.ddsutn.group01.tpanual.procesos.Frecuencia.Frecuencia;
import com.ddsutn.group01.tpanual.procesos.Log.Log;
import org.joda.time.DateTime;

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
        this.log.guardar(cantidadDeResultados, DateTime.now(), estado);
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
