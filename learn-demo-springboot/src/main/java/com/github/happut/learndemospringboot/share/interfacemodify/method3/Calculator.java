package com.github.happut.learndemospringboot.share.interfacemodify.method3;

public interface Calculator {
    double operate(double a, double b);

    static Calculator getInstance() {
        return new Calculator() {
            @Override
            public double operate(double a, double b) {
                return a + b;
            }
        };
    }
}
