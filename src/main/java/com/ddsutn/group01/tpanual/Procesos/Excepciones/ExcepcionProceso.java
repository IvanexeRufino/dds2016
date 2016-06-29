package com.ddsutn.group01.tpanual.Procesos.Excepciones;

import com.ddsutn.group01.tpanual.Procesos.Proceso;

public interface ExcepcionProceso {
    void manejarError(Proceso process, Exception error) throws Exception;
}
