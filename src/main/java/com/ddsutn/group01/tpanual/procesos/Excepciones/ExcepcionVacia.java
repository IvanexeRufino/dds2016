package com.ddsutn.group01.tpanual.procesos.Excepciones;

import com.ddsutn.group01.tpanual.procesos.Proceso;

public class ExcepcionVacia implements ExcepcionProceso {

    @Override
    public void manejarError(Proceso process) {
        process.estadoError();
    }

}
