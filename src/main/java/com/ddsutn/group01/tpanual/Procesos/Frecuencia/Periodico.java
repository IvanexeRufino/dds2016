package com.ddsutn.group01.tpanual.Procesos.Frecuencia;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.ddsutn.group01.tpanual.repositories.Frecuencia;

public class Periodico implements Frecuencia{
    
    private Date dia;
    private long periodo;
    private Timer temporizador ;
    
    public Periodico(Date diaDeInicio, long periodo) {
        this.dia = diaDeInicio;
        this.periodo = periodo;
        temporizador = new Timer();
    }
    
    public void activarProceso (Runnable ejecutable) throws InterruptedException {   
        TimerTask timer = new TimerTask() {
            public void run() { 
                try {
                    temporizador.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ejecutable.run();
                temporizador.notifyAll();}
            };      
        temporizador.scheduleAtFixedRate(timer,dia, periodo);
    }

}
