package com.basics.Stratergy.Duck;

public abstract class Duck {
    Fly fly;
    Quack quack;

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public void setQuack(Quack quack) {
        this.quack = quack;
    }

    public void swim() {
        System.out.println("We love to swim");
    }

    public abstract void fly();

    public abstract void quack();
}
