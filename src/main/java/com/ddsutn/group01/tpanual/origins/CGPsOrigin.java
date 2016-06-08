package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.adapters.CGP.CGPAdapter;
import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;
import com.ddsutn.group01.tpanual.dataSources.DataSourceCGP;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

class CGPsOrigin implements Origin {
    private DataSourceCGP dataSource;

    CGPsOrigin(DataSourceCGP dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        ArrayList<CentroDTO> result = dataSource.search(criteria);
        return CGPAdapter.adapt(result);
    }
}
