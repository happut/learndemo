package com.github.happut.learndemospringboot.study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {

//        String[] ids = new String[]{"YDJ0535Q4MQFWZXY", "YDJ0535Q4MNDXWYZ"};
//        String[] ids = new String[]{"YDJ0535Q4M9BEWZX","YDJ0535Q4M9D9YZY"};
        String[] ids = new String[]{"YDJ0535Q4M5E1WWX"};

        Arrays.stream(ids).forEach(id -> {


            for (int i = 0; i < 300; i++) {
                try {
                    String result = Jsoup.connect("https://c.m.163.com/reader/api/recommend/praise/add")
                            .header("Content-Type", "application/x-www-form-urlencoded")
                            .data("recommendId", id)
                            .ignoreContentType(true)
                            .post()
                            .text();
//                    System.out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });

        Arrays.stream(ids).forEach(id -> {


            try {
                Element body = Jsoup.connect("https://c.m.163.com/news/rec/" + id + ".html?spss=newsapp").get().body();
                String attr = body.select(".js-like").attr("data-vote");
                System.out.println(id + ":" + attr);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });


    }
}
