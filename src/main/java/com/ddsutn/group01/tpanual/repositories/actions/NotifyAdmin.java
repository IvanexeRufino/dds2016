package com.ddsutn.group01.tpanual.repositories.actions;

import com.ddsutn.group01.tpanual.tools.mailers.Mailer;
import com.ddsutn.group01.tpanual.tools.mailers.MailgunMailer;

public class NotifyAdmin implements Action {
    private int secondsBeforeNotify = 1;
    private long time;
    private Mailer mailer = new MailgunMailer();

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
