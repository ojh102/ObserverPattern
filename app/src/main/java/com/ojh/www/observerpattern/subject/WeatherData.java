package com.ojh.www.observerpattern.subject;

import com.ojh.www.observerpattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JaeHwan Oh on 2016-05-18.
 */
public class WeatherData implements Subject{
    private List<Observer> observers;
    private int temperature;
    private int humidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(temperature, humidity);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(int tremperature, int humidity) {
        this.temperature = tremperature;
        this.humidity = humidity;
        measurementsChanged();
    }
}
