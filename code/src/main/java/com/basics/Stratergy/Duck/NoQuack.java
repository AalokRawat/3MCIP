package com.basics.Stratergy.Duck;

public class NoQuack implements Quack {

    @Override
    public void action() {
        System.out.println("No quack");
    }
}
