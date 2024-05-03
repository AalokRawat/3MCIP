package com.basics.Decorator.Starbuzz;

public class Soya extends AddOn {

    public Soya(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return 0 + beverage.cost();
    }
}
