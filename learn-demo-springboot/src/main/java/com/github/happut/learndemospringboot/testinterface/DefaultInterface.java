package com.github.happut.learndemospringboot.testinterface;

public interface DefaultInterface {

    String a();

    default String b() {
        return "parent:b";
    }

    static String staticMethod() {
        return "c";
    }
}
