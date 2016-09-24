package com.ddsutn.group01.tpanual.procesos.Excepciones;

import com.ddsutn.group01.tpanual.procesos.Proceso;

public class ExcepcionIntentos implements ExcepcionProceso {

    private int cantidadDeIntentos;
    private int contador;
    private ExcepcionProceso handler;

    public ExcepcionIntentos(int cantidad, ExcepcionProceso handler) {
        this.cantidadDeIntentos = cantidad;
        this.resetearContador();
        this.handler = handler;
    }

    private void resetearContador() {
        contador = 0;
    }

    private void aumentarContador() {
        contador = contador + 1;
    }

    @Override
    public void manejarError(Proceso process) {
        this.aumentarContador();
        if (cantidadDeIntentos > contador) {
            try {
                process.ejecutar();
            } catch (Exception e) {
                this.manejarError(process);
            }
        } else {
            handler.manejarError(process);
            this.resetearContador();
        }
    }
}

