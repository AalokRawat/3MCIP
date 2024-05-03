package com.basics.Decorator.Starbuzz;

public class Chocolate extends AddOn {

    public Chocolate(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return 0 + beverage.cost();
    }
}
