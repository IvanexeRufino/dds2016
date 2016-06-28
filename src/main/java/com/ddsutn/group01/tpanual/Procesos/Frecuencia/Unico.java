package com.ddsutn.group01.tpanual.Procesos.Frecuencia;

import com.ddsutn.group01.tpanual.repositories.Frecuencia;

public class Unico implements Frecuencia {

    @Override
    public void activarProceso(Runnable ejecutable) throws InterruptedException {
        ejecutable.run();
    }

}
