package com.ddsutn.group01.tpanual.Procesos.Excepciones;

import com.ddsutn.group01.tpanual.Procesos.Proceso;
import com.ddsutn.group01.tpanual.tools.mailers.Mailer;

public class ExcepcionMail implements ExcepcionProceso {
    
    private Mailer mailer;
    
    public ExcepcionMail (Mailer unMailer) {
        this.mailer = unMailer;
    }
    
    @Override
    public void manejarError(Proceso process)  {
        process.estadoError();
        try{
        mailer.send("admin@gmail.com", "error", "error en proceso");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
