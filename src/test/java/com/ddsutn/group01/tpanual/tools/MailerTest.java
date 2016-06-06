package com.ddsutn.group01.tpanual.tools;

import org.junit.Test;

public class MailerTest {

    @Test (expected = Exception.class)
    public void problemsSendingEmailToAMalformedEmail() throws Exception {
        Mailer.send("daianaespinoza1@gm@ail.com", "Hola, test automatico", "hola mundo");
    }

    @Test
    public void sentOK() throws Exception {
        Mailer.send("daianaespinoza200@mailinator.com", "Hola, test automatico", "hola mundo");
    }
}