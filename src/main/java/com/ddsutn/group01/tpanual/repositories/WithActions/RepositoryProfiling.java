package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.observers.Observer;
import com.ddsutn.group01.tpanual.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryProfiling extends RepositoryWithActions {
    private int secondsBeforeNotify = 1;
    private List<Observer> observers;

    public RepositoryProfiling(Repository repository) {
        super(repository);
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public long getSecondsBeforeNotify() {
        return secondsBeforeNotify;
    }

    public void setSecondsBeforeNotify(int secondsBeforeNotify) {
        this.secondsBeforeNotify = secondsBeforeNotify;
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

    private boolean maxTimeLapsed(long timeLapsed) {
        long maxTimeInNanoSeconds = secondsBeforeNotify * 1000000000;
        return timeLapsed > maxTimeInNanoSeconds;
    }

    private void notifyObservers() {
        observers.stream().forEach(Observer::inform);
    }
}
