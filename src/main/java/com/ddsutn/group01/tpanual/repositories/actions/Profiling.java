//package com.ddsutn.group01.tpanual.repositories.actions;
//
//import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
//import com.ddsutn.group01.tpanual.repositories.RepositoryWithActions;
//import com.ddsutn.group01.tpanual.tools.observers.Observer;
//import com.ddsutn.group01.tpanual.repositories.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Profiling implements Action {
//    private int secondsBeforeNotify = 1;
//    private List<Observer> observers = new ArrayList<>();
//
//    public void addObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    public long getSecondsBeforeNotify() {
//        return secondsBeforeNotify;
//    }
//
//    public void setSecondsBeforeNotify(int secondsBeforeNotify) {
//        this.secondsBeforeNotify = secondsBeforeNotify;
//    }
//
//    @Override
//    public List<PointOfInterest> postCondition(String criteria) {
//        long startTime = System.nanoTime();
//        List<PointOfInterest> result = repository.find(criteria);
//        long estimatedTime = System.nanoTime() - startTime;
//
//        if (maxTimeLapsed(estimatedTime)) {
//            notifyObservers();
//        }
//
//        return result;
//    }
//
//    private boolean maxTimeLapsed(long timeLapsed) {
//        long maxTimeInNanoSeconds = secondsBeforeNotify * 1000000000;
//        return timeLapsed > maxTimeInNanoSeconds;
//    }
//
//    private void notifyObservers() {
//        observers.stream().forEach(Observer::inform);
//    }
//
//    @Override
//    public void precondition() {
//        // TODO Auto-generated method stub
//        
//    }
//
//    @Override
//    public void postcondition(String criteria, List<PointOfInterest> result) {
//        // TODO Auto-generated method stub
//        
//    }
//}
