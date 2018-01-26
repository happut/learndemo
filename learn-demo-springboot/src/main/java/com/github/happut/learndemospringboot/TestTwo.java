package com.github.happut.learndemospringboot;

import org.springframework.stereotype.Repository;

@DataEngine
public class TestTwo implements ITestInterface {
    @Override
    public String getName() {
        return "testTwo";
    }

    @Override
    public void fuck() {

    }
}
