package com.github.happut.learndemospringboot.mp.code1;

public class Son extends Father {
    @Override
    public void method() {
        System.out.println("son:method");
    }

    public static int test;

    public static void staticMethod() {
        System.out.println("son:static:method");
    }
}
