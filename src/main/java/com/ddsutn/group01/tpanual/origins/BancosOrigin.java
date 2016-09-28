package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.adapters.Banco.BancoAdapter;
import com.ddsutn.group01.tpanual.dataSources.DataSourceBanco;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;

import java.util.List;

class BancosOrigin implements Origin {
    private DataSourceBanco dataSource;
    private PoisCache cache = new PoisCache();

    BancosOrigin(DataSourceBanco dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<PointOfInterest> find(String searchText) {
        List<String> result = cache.get(searchText);

        if (result.isEmpty()) {
            result = dataSource.search(searchText);
            cache.put(searchText, result);
        }

        return BancoAdapter.adapt(result);
    }
}
