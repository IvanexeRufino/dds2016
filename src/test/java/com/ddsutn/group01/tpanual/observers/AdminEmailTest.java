package com.ddsutn.group01.tpanual.observers;

import com.ddsutn.group01.tpanual.tools.Mailer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class AdminEmailTest {
    private Mailer mockedMailer;
    private AdminEmail adminEmail;

    @Before
    public void setUp() throws Exception {
        mockedMailer = Mockito.spy(new Mailer() {
            @Override
            public void send(String to, String subject, String content) throws Exception { }
        });
        adminEmail = new AdminEmail(mockedMailer);

    }

    @Test
    public void inform() throws Exception {
        adminEmail.inform();
        verify(mockedMailer).send(any(String.class), any(String.class), any(String.class));
    }
}
