package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.adapters.Banco.BancoAdapter;
import com.ddsutn.group01.tpanual.dataSources.DataSourceBanco;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

class BancosOrigin implements Origin {
    private DataSourceBanco dataSource;

    BancosOrigin(DataSourceBanco dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        ArrayList<String> result = dataSource.search(criteria);
        return BancoAdapter.adapt(result);
    }
}
