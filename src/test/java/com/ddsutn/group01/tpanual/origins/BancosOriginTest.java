package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.mocks.ExternalSourceBancoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BancosOriginTest {
    private BancosOrigin origin;

    @Before
    public void setUp() throws Exception {
        ExternalSourceBancoMock externalSource = new ExternalSourceBancoMock();
        origin = new BancosOrigin(externalSource);
    }

    @Test
    public void find() throws Exception {
        Assert.assertFalse(origin.find("Banco de la Plaza").isEmpty());
    }
}
