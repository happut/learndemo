package com.github.happut.learndemospringboot;

import org.springframework.stereotype.Repository;

@Repository
public class TestTwo implements ITestInterface {
    @Override
    public String getName() {
        return "testTwo";
    }

    @Override
    public void fuck() {

    }
}
