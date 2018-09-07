package com.github.happut.learndemospringboot.study;

import com.google.common.collect.Lists;
import org.mortbay.util.ajax.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        List<Person> people = Lists.newArrayList(new Person(1, "aa"), new Person(2, "bb"), new Person(3, "cc"));
        Map<Integer, String> collect = people.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
        System.out.println(JSON.toString(collect));
    }
}
