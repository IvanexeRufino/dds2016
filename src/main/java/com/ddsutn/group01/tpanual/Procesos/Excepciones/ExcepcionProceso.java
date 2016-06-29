package com.ddsutn.group01.tpanual.Procesos.Excepciones;

import com.ddsutn.group01.tpanual.Procesos.Proceso;

public interface ExcepcionProceso {
    
    public abstract void manejarError(Proceso process) throws Exception ;
}