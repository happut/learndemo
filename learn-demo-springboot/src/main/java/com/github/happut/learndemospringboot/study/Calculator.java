package com.github.happut.learndemospringboot.study;

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
