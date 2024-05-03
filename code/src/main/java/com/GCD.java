package com;

public class GCD {

    public static void main(String[] args) {
        System.out.println(new GCD().execute(98, 56));
    }

    int execute(int x, int y) {
        if(x==y) {
            return x;
        }
        x=x-y;
        if(x>y)
            return execute(x, y);
        return execute(y, x);
    }
}
