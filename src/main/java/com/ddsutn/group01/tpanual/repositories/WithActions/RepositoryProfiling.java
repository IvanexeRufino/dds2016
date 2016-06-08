package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.observers.Observer;
import com.ddsutn.group01.tpanual.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryProfiling extends RepositoryWithActions {
    private long maxTimeBeforeNotify = 1000000000;
    private List<Observer> observers;

    public RepositoryProfiling(Repository repository) {
        super(repository);
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public long getMaxTimeBeforeNotify() {
        return maxTimeBeforeNotify;
    }

    public void setMaxTimeBeforeNotify(long maxTimeBeforeNotify) {
        this.maxTimeBeforeNotify = maxTimeBeforeNotify;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        long startTime = System.nanoTime();
        List<PointOfInterest> result = repository.find(criteria);
        long estimatedTime = System.nanoTime() - startTime;

        if (maxTimeLapsed(estimatedTime)) {
            notifyObservers();
        }

        return result;
    }

    private boolean maxTimeLapsed(long time) {
        return time > maxTimeBeforeNotify;
    }

    private void notifyObservers() {
        observers.stream().forEach(Observer::inform);
    }
}
