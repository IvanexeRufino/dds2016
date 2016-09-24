package com.ddsutn.group01.tpanual;

import com.ddsutn.group01.tpanual.repositories.actions.NotifyAdmin;
import com.ddsutn.group01.tpanual.tools.mailers.Mailer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;


public class PersistentActionTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    @Test
    public void test() {
        NotifyAdmin notification = new NotifyAdmin(Mockito.mock(Mailer.class));
        notification.setSecondsBeforeNotify(10);
        entityManager().persist(notification);
        NotifyAdmin persistedNotification = entityManager().find(NotifyAdmin.class, notification.getId());

        Assert.assertEquals(persistedNotification.getId(), notification.getId());
    }

}
