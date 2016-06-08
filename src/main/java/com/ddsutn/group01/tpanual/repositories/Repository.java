package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;

public interface Repository {
    void add(PointOfInterest poi);
    void edit(PointOfInterest poi);
    void remove(PointOfInterest poi);
    List<PointOfInterest> find(String criteria);
}
