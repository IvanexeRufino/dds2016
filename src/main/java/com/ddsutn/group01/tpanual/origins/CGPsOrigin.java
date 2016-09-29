package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.adapters.Banco.Mapper;
import com.ddsutn.group01.tpanual.adapters.CGP.CGPAdapter;
import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;
import com.ddsutn.group01.tpanual.dataSources.DataSourceCGP;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.tools.poisCache.PoisCache;

import java.util.HashMap;
import java.util.List;

class CGPsOrigin implements Origin {
    private DataSourceCGP dataSource;
    private PoisCache cache = new PoisCache();
    private HashMap<String, String> map = new HashMap<>();

    CGPsOrigin(DataSourceCGP dataSource) {
        this.dataSource = dataSource;
    }

    public void setCache(PoisCache cache) {
        this.cache = cache;
    }

    @Override
    public List<PointOfInterest> find(String searchText) {
        String resultCacheado = cache.get(searchText, map);

        if (resultCacheado.isEmpty()) {
            List<CentroDTO> result = dataSource.search(searchText);
            resultCacheado = Mapper.obtenerJSONDelCGP(result);
            cache.put(searchText, resultCacheado, map);

            return CGPAdapter.adapt(result);
        } else {
            return CGPAdapter.adapt(Mapper.mappearCGP(resultCacheado));
        }
    }
}
