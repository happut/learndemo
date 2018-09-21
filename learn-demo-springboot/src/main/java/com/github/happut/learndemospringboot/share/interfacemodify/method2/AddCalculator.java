package com.github.happut.learndemospringboot.share.interfacemodify.method2;

public interface AddCalculator {
    double add(double a, double b);

    default double add(double a, double b, double c) {
        return a + b + c;
    }
}
