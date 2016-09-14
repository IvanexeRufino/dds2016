package com.ddsutn.group01.tpanual.repositories.actions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.ddsutn.group01.tpanual.tools.mailers.Mailer;
import com.ddsutn.group01.tpanual.tools.mailers.MailgunMailer;

@Entity
public class NotifyAdmin extends Action {
	@Column
    private long secondsBeforeNotify = 1;
    @Column
	private long time;
    @Transient
    private Mailer mailer = new MailgunMailer();
    
    public long getTime(){
    	return time;
    }
    
    public void setTime(long time){
    	this.time = time;
    }
    
    public long getSecondsBeforeNotify() {
        return secondsBeforeNotify;
    }

    public void setSecondsBeforeNotify(int secondsBeforeNotify) {
        this.secondsBeforeNotify = secondsBeforeNotify;
    }

    private boolean maxTimeLapsed(long timeLapsed) {
        return timeLapsed > secondsBeforeNotify * 1000000000;
    }

    private void notifyAdmin() {
        try {
            mailer.send("admin@gmail.com.ar", "Tiempo de busqueda superado", "la busqueda tardo demasiado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void precondition() {
        time = System.nanoTime();
    }

    @Override
    public void postcondition(String criteria, int result, String nombre) {
        time = System.nanoTime() - time;
        if (maxTimeLapsed(time)) {
            notifyAdmin();
        }     
    }
}
