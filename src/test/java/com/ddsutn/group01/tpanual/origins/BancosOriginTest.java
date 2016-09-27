package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.mocks.DataSourceBancoMock;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BancosOriginTest {
    private BancosOrigin origin;

    @Before
    public void setUp() throws Exception {
        DataSourceBancoMock externalSource = new DataSourceBancoMock();
        origin = new BancosOrigin(externalSource);
    }

    @Test
    public void find() throws Exception {
        Assert.assertFalse(origin.find("Banco de la Plaza").isEmpty());
    }
    
    @Test
    public void cacheConInfo() {
    	PoisCache cache = new PoisCache();
    	List<String> listaCacheada = cache.get("Banco de la Plaza");
    	Assert.assertFalse(listaCacheada.isEmpty());
    	
    }
}
