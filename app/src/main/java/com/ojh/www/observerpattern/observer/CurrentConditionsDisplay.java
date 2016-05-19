package com.ojh.www.observerpattern.observer;

import android.util.Log;

import com.ojh.www.observerpattern.DisplayElement;
import com.ojh.www.observerpattern.subject.Subject;

/**
 * Created by JaeHwan Oh on 2016-05-18.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private int temperature;
    private int humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity ) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        Log.d("날씨","현재 날씨 : "+temperature+"도, "+humidity+"% 습도");
    }
}
