package com.ddsutn.group01.tpanual.procesos.Frecuencia;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Frecuencia {

    protected Date dia;
    protected long periodo;
    protected Timer timer = new Timer();

    public void activarProceso (Runnable ejecutable) {
        TimerTask timer = new TimerTask() {
            public void run() {
                ejecutable.run();
                }
            };
        this.schedule(timer);
    }

    public abstract void schedule (TimerTask timer);
}
