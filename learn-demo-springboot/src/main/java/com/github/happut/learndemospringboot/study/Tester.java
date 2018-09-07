package com.github.happut.learndemospringboot.study;

public class Tester {
    public static void main(String[] args) {
        Calculator add = new Calculator() {
            @Override
            public double operate(double a, double b) {
                return a + b;
            }
        };
        System.out.println(add.operate(1, 2));

        Calculator add1 = (double a, double b) -> {
            return a + b;
        };
        System.out.println(add1.operate(1, 2));


        Calculator add2 = (a, b) -> a + b;
        System.out.println(add2.operate(1, 2));

        System.out.println(((Calculator) (a, b) -> a + b).operate(1, 2));
    }
}
