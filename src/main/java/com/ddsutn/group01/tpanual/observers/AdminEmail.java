package com.ddsutn.group01.tpanual.observers;

import com.ddsutn.group01.tpanual.tools.Mailer;

public class AdminEmail implements Observer {
    private String email;
    private String subject;
    private String content;

    public AdminEmail(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void inform() {
        try {
            Mailer.send(email, subject, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
