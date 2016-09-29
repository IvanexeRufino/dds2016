package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.adapters.Banco.BancoAdapter;
import com.ddsutn.group01.tpanual.dataSources.DataSourceBanco;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;

import java.util.HashMap;
import java.util.List;

class BancosOrigin implements Origin {
    private DataSourceBanco dataSource;
    private PoisCache cache = new PoisCache();
    private HashMap<String, String> map = new HashMap<>();

    BancosOrigin(DataSourceBanco dataSource) {
        this.dataSource = dataSource;
    }

    public void setCache(PoisCache cache) {
        this.cache = cache;
    }


    @Override
    public List<PointOfInterest> find(String searchText) {
        String result = cache.get(searchText, map);
        if (result.isEmpty()) {
            result = dataSource.search(searchText);
            cache.put(searchText, result, map);
        }
        return BancoAdapter.adapt(result);
    }
}
