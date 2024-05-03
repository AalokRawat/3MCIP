package com.basics.Decorator.Starbuzz;

public class Milk extends AddOn {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return 0 + beverage.cost();
    }
}
