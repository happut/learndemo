package com.github.happut.learndemospringboot.testinterface;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.ArrayUtils;
import org.mortbay.util.ajax.JSON;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestImpl {

    public void test(Test s) {
        System.out.println(s.a("test"));
    }

    public static void main(String[] args) {
        TestImpl t = new TestImpl();

        String abc1 = "test";
        String abc2 = "test";

        t.test(new Test() {
            @Override
            public String a(String s) {
                return s + abc1;
            }
        });

        new Thread(() -> {
            System.out.println(abc1);

        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(abc2);
            }
        });


        List<String> list1 = Lists.newArrayList("a", "b", "c");

        Map<String, String> map1 = Maps.newHashMap();
        map1.put("a", "1");
        map1.put("b", "2");
        map1.put("c", "3");

        for (String s : list1) {
            System.out.println(s);
        }

        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        list1.forEach(s -> System.out.println(s));

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value=" + entry.getValue());
        }

        map1.forEach((key, value) -> System.out.println("key:" + key + ", value=" + value));

        List<String> result = list1.stream()
                .distinct()
                .filter(s -> !s.equals("a"))
                .map(e -> Base64.getEncoder().encodeToString(e.getBytes()))
                .peek(e -> System.out.println(e + "c"))
                .limit(2)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(ArrayUtils.toString(result));

        Map<String, String> collect = list1.stream().collect(Collectors.toMap(s -> "key:" + s, s -> "value:" + s));
        System.out.println(JSON.toString(collect));


        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> figures = Stream.of(a, b).flatMap(u -> u.stream()).collect(Collectors.toList());
        figures.forEach(f -> System.out.println(f));


    }
}
