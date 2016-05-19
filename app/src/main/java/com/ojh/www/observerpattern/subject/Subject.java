package com.ojh.www.observerpattern.subject;


import com.ojh.www.observerpattern.observer.Observer;

/**
 * Created by JaeHwan Oh on 2016-05-18.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
