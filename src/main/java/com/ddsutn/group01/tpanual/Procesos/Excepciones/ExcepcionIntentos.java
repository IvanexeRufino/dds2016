package com.ddsutn.group01.tpanual.Procesos.Excepciones;

import com.ddsutn.group01.tpanual.Procesos.Proceso;

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

    @Override
    public void manejarError(Proceso process) throws Exception {
        process.setEstado("Error");
        if(cantidadDeIntentos>contador){
            process.ejecutar(); 
        }
        else {
            handler.manejarError(process);
            this.resetearContador();
        }
        
    }
}
    
