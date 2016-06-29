package com.ddsutn.group01.tpanual.Procesos.Frecuencia;

public class Unico implements Frecuencia {

    @Override
    public void activarProceso(Runnable ejecutable) throws InterruptedException {
        ejecutable.wait();
        ejecutable.run();
        ejecutable.notify();
    }

}
