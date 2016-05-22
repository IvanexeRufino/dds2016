package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.adapters.CGP.CGPAdapter;
import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;
import com.ddsutn.group01.tpanual.externalSources.ExternalSourceCGP;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

public class CGPsOrigin implements Origin {
    private ExternalSourceCGP api;

    public CGPsOrigin(ExternalSourceCGP externalComponent) {
        this.api = externalComponent;
    }

    @Override
    public void add(PointOfInterest poi) {
    }

    @Override
    public void edit(PointOfInterest poi) {
    }

    @Override
    public void remove(PointOfInterest poi) {
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        ArrayList<CentroDTO> result = api.search(criteria);
        return CGPAdapter.adapt(result);
    }
}
