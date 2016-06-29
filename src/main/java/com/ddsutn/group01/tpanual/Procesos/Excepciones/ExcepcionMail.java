package com.ddsutn.group01.tpanual.Procesos.Excepciones;

import com.ddsutn.group01.tpanual.Procesos.Proceso;
import com.ddsutn.group01.tpanual.tools.mailers.MailgunMailer;

public class ExcepcionMail implements ExcepcionProceso {
    
    private MailgunMailer mailer;
    
    public ExcepcionMail(MailgunMailer mailer) {
        this.mailer = mailer;
    }
    
    @Override
    public void manejarError(Proceso process, Exception error)  {
        try{
        mailer.send("admin@gmail.com", "error", "error en proceso"+process.getClass());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
