package com.github.happut.learndemospringboot.share.lambdaexpression.exp1;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c", "d");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        Collections.sort(list, (a, b) -> a.compareTo(b));

        Supplier<Double> random = Math::random;
        Stream.generate(() -> 2).limit(20).forEach(System.out::println);
    }
}
