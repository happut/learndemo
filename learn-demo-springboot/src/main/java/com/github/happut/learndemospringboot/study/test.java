package com.github.happut.learndemospringboot.study;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        FileUtils.readLines(new File("D:\\bodan")).forEach(row -> {
            System.out.println(row);
        });
    }
}
