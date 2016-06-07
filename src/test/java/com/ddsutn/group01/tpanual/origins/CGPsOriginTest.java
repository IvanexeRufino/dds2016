package com.ddsutn.group01.tpanual.origins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.ddsutn.group01.tpanual.models.mocks.ExternalSourceCGPMock;

public class CGPsOriginTest {
    private CGPsOrigin origin;

    @Before
    public void setUp() throws Exception {
        ExternalSourceCGPMock externalSource = new ExternalSourceCGPMock();
        origin = new CGPsOrigin(externalSource);
    }
    
    @Test
    public void find() throws Exception {
        Assert.assertFalse(origin.find("rivadavia").isEmpty());
    }
}
