package com.ddsutn.group01.tpanual;

import com.ddsutn.group01.tpanual.actions.ActionWithAdminNotification;
import com.ddsutn.group01.tpanual.tools.mailers.Mailer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;


public class PersistentActionTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    @Test
    public void test() {
        ActionWithAdminNotification notification = new ActionWithAdminNotification(Mockito.mock(Mailer.class));
        notification.setSecondsBeforeNotify(10);
        entityManager().persist(notification);
        ActionWithAdminNotification persistedNotification = entityManager().find(ActionWithAdminNotification.class, notification.getId());

        Assert.assertEquals(persistedNotification.getId(), notification.getId());
    }

}
