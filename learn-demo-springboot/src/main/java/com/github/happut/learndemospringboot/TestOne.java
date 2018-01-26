package com.github.happut.learndemospringboot;

import org.springframework.stereotype.Repository;

@DataEngine(value = "test", engine = "what")
public class TestOne implements ITestInterface {
    @Override
    public String getName() {
        return "testOne";
    }

    @Override
    public void fuck() {

    }
}
