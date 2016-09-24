package com.ddsutn.group01.tpanual.origins;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;

public interface Origin {
    List<PointOfInterest> find(String criteria);
}
