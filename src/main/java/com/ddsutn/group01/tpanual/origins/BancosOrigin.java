package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.adapters.Banco.BancoAdapter;
import com.ddsutn.group01.tpanual.externalSources.ExternalSourceBanco;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

public class BancosOrigin implements Origin {
    private ExternalSourceBanco api;

    public BancosOrigin(ExternalSourceBanco api) {
        this.api = api;
    }
    
    @Override
    public List<PointOfInterest> find(String criteria) {
        ArrayList<String> result = api.search(criteria);
        return BancoAdapter.adapt(result);
    }
}
