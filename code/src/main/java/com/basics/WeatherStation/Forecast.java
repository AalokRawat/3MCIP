package com.basics.WeatherStation;

public class Forecast extends Observer implements Display {

    public Forecast(Subject subject) {
        super(subject);
    }

    @Override
    public void update(Subject subject) {

    }

    @Override
    public void show() {

    }
}
