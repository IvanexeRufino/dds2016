package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class RepositoryWithActions implements Repository {
    private Repository repository;
    private ArrayList<Action> actions;

    public RepositoryWithActions(Repository repository) {
        this.repository = repository;
        actions = new ArrayList<>();
    }

    @Override
    public void add(PointOfInterest poi) {
        repository.add(poi);
    }

    @Override
    public void edit(PointOfInterest poi) {
        repository.edit(poi);
    }

    @Override
    public void remove(PointOfInterest poi) {
        repository.remove(poi);
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        actions.forEach(Action::precondition);
        List<PointOfInterest> result = repository.find(criteria);
        actions.forEach(action -> action.postcondition(criteria, result));

        return result;
    }
}
