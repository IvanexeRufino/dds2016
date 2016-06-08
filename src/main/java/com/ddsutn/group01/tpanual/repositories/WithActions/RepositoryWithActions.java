package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;

import java.util.List;

abstract class RepositoryWithActions implements Repository {
    Repository repository;

    RepositoryWithActions(Repository repository) {
        this.repository = repository;
    }

    @Override
    final public void add(PointOfInterest poi) {
        repository.add(poi);
    }

    @Override
    final public void edit(PointOfInterest poi) {
        repository.edit(poi);
    }

    @Override
    final public void remove(PointOfInterest poi) {
        repository.remove(poi);
    }

    @Override
    public abstract List<PointOfInterest> find(String criteria);
}
