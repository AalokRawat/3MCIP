package com.basics.WeatherStation;

public abstract class Observer {
    Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
    }

    abstract void update(Subject subject);
}
