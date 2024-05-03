package com.basics.Decorator.Starbuzz;

public abstract class AddOn implements Beverage {
    Beverage beverage;

    public AddOn(Beverage beverage) {
        this.beverage = beverage;
    }
}
