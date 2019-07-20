package com.github.happut.learndemospringboot.leecode.problem509;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(40));
    }

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        for (int i = 2; i <= N; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
