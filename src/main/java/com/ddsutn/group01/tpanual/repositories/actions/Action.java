package com.ddsutn.group01.tpanual.repositories.actions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

import java.util.List;

public interface Action {
    void precondition();
    void postcondition(String criteria, List<PointOfInterest> result);
}
