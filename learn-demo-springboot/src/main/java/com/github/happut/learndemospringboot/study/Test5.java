package com.github.happut.learndemospringboot.study;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test5 {
    public static void main(String[] args) {
        Map<String,String> s = new HashMap<>();

        s.put("a","b");

        Map<String,String> s2 = new ConcurrentHashMap<>();
    }
}
