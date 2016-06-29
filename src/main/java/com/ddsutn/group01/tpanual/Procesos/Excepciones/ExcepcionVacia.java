package com.ddsutn.group01.tpanual.Procesos.Excepciones;

import com.ddsutn.group01.tpanual.Procesos.Proceso;

public class ExcepcionVacia implements ExcepcionProceso {
    
    @Override
    public void manejarError(Proceso process) throws Exception { 
        process.setEstado("Error");
    }

}
