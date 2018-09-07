package com.github.happut.learndemospringboot.testinterface;

public interface DefaultInterface {

    double add(double a, double b);

    default double addThree(double a, double b, double c) {

        return a + b + c;
    }

    static String staticMethod() {
        return "c";
    }
}
