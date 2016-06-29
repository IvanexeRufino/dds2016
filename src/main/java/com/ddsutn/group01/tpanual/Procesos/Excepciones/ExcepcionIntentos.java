package com.ddsutn.group01.tpanual.Procesos.Excepciones;

import com.ddsutn.group01.tpanual.Procesos.Proceso;
import com.ddsutn.group01.tpanual.tools.mailers.MailgunMailer;

public class ExcepcionIntentos implements ExcepcionProceso {
    
    private int cantidadDeIntentos;
    private int contador;
    private MailgunMailer mailer;
    private Boolean mailAdmin;
    
    public ExcepcionIntentos(int cantidad, Boolean mailAdmin) {
        this.cantidadDeIntentos = cantidad;
        this.resetearContador();
        this.mailAdmin = mailAdmin;
    }
    
    private void resetearContador() {
        contador = 0;
    }
    
    public void manejarExcepcion (Exception error) {
        if (contador<cantidadDeIntentos) {
            
        }
    }

    @Override
    public void manejarError(Proceso process, Exception error) throws Exception {
        if(cantidadDeIntentos>contador){
            process.ejecutar(); 
        }
        else {
            this.resetearContador();
            if (mailAdmin) {
                mailer = new MailgunMailer();
                mailer.send("admin@gmail.com", "error", "error en proceso"+process.getClass());
            }
        }
    }
    
}
