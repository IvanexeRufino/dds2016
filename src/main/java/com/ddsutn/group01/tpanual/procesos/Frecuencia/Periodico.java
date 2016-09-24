package com.ddsutn.group01.tpanual.procesos.Frecuencia;

import java.util.Date;
import java.util.TimerTask;

public class Periodico extends Frecuencia {

    private long periodo;

    public Periodico(Date diaDeInicio, long periodo) {
        this.dia = diaDeInicio;
        this.periodo = periodo;
    }

    public void schedule(TimerTask task) {
        timer.scheduleAtFixedRate(task, dia, periodo);
    }

}
