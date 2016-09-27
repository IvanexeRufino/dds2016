package com.ddsutn.group01.tpanual.tools.poisCache;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PoisCacheTest {

    private PoisCache cache = new PoisCache();

    @Test
    public void get() throws Exception {
        List<PointOfInterest> result = cache.get("new key");
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void put() throws Exception {
        List<PointOfInterest> result = new ArrayList<>();
        result.add(Mockito.mock(PointOfInterest.class));

        cache.put("key", result);

        Assert.assertEquals(result, cache.get(("key")));
    }

}
