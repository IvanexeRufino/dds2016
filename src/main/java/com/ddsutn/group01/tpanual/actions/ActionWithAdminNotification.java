package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.tools.mailers.Mailer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ActionWithAdminNotification extends Action {
	@Column
    private long secondsBeforeNotify = 1;

    @Column
	private long time;

    @Transient
    private Mailer mailer;

    public ActionWithAdminNotification(Mailer mailer) {
        this.mailer = mailer;
    }

    public long getTime(){
    	return time;
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
    public void postcondition(String searchText, int result, String nombre) {
        time = System.nanoTime() - time;

        if (maxTimeLapsed(time)) {
            notifyAdmin();
        }
    }
}
