package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.mocks.DataSourceBancoMock;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BancosOriginTest {
    private BancosOrigin origin;

    @Before
    public void setUp() throws Exception {
        DataSourceBancoMock externalSource = new DataSourceBancoMock();
        PoisCache cache = Mockito.mock(PoisCache.class);
        origin = new BancosOrigin(externalSource);
    }

    @Test
    public void find() throws Exception {
        Assert.assertFalse(origin.find("Banco de la Plaza").isEmpty());
    }

}
