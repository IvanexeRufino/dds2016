package com.ddsutn.group01.tpanual.Procesos.Frecuencia;

import java.util.Date;
import java.util.TimerTask;

public class Unico extends Frecuencia {

    public Unico (Date dia) {
        this.dia = dia;
    }
    
    @Override
    public void schedule(TimerTask task) {
        timer.schedule(task,dia);
    }

}
