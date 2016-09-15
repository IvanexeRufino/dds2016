package com.ddsutn.group01.tpanual.tools.mailers;

public interface Mailer {
    void send(String to, String subject, String content) throws Exception;
}
