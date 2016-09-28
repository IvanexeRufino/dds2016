package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.mocks.DataSourceBancoMock;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;

import static org.mockito.Matchers.any;

import java.util.HashMap;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BancosOriginTest {
    private BancosOrigin origin;
    private PoisCache cache;

    @Before
    public void setUp() throws Exception {
        DataSourceBancoMock externalSource = new DataSourceBancoMock();
        cache = Mockito.spy(new PoisCache() {
        	public Boolean cacheado(String map, String key) {return false;}
        	public String get(String string, HashMap<String,String> map) {return "";}
        	public void put(String key, String data, HashMap<String,String> map){}
        });
        origin = new BancosOrigin(externalSource);
        origin.setCache(cache);
    }

    @Test
    public void find() throws Exception {
        Assert.assertFalse(origin.find("Banco de la Plaza").isEmpty());
    }

}
