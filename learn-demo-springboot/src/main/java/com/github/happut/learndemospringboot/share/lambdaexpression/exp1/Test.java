package com.github.happut.learndemospringboot.share.lambdaexpression.exp1;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;

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
//        Stream.generate(() -> 2).limit(20).forEach(System.out::println);

        int sum = IntStream.rangeClosed(1, 10).reduce((x, y) -> x + 2 * y).orElse(0);
        System.out.println(sum);

        String wangfei = "wangfei";
        Optional<String> wangfeio = Optional.ofNullable(wangfei);
        Optional<String> wangfei2 = Optional.ofNullable(null);

        wangfeio.ifPresent(e -> System.out.println(e));
        wangfei2.ifPresent(e -> System.out.println(e));
        System.out.println(wangfeio.orElse("null String"));
        System.out.println(wangfei2.orElse("null String"));
        System.out.println(wangfei2.orElseGet(() -> "wangfei"));



    }
}
