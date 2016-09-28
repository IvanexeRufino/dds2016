package com.ddsutn.group01.tpanual.origins;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ddsutn.group01.tpanual.models.mocks.DataSourceCGPMock;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;

public class CGPsOriginTest {
    private CGPsOrigin origin;
    private PoisCache cache;

    @Before
    public void setUp() throws Exception {
        DataSourceCGPMock externalSource = new DataSourceCGPMock();
        cache = Mockito.spy(new PoisCache() {
        	public Boolean cacheado(String map, String key) {return false;}
        	public String get(String string, HashMap<String,String> map) {return "";}
        	public void put(String key, String data, HashMap<String,String> map){}
        });
        origin = new CGPsOrigin(externalSource);
        origin.setCache(cache);
    }

    @Test
    public void find() throws Exception {
        Assert.assertFalse(origin.find("rivadavia").isEmpty());
    }
}
