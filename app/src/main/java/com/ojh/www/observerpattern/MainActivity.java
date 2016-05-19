package com.ojh.www.observerpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ojh.www.observerpattern.observer.CurrentConditionsDisplay;
import com.ojh.www.observerpattern.observer.FutureConditionsDisplay;
import com.ojh.www.observerpattern.observer.Observer;
import com.ojh.www.observerpattern.subject.WeatherData;

public class MainActivity extends AppCompatActivity {

    Button button;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);

        final WeatherData weatherData = new WeatherData();
        final Observer currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        final Observer futureConditionsDisplay = new FutureConditionsDisplay(weatherData);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count) {
                    case 1:
                        weatherData.removeObserver(currentConditionsDisplay);
                        break;
                    case 2:
                        weatherData.removeObserver(futureConditionsDisplay);
                        break;
                }
                weatherData.setMeasurements((int)(Math.random()*100),(int)(Math.random()*100));
                count++;
            }
        });

    }
}
