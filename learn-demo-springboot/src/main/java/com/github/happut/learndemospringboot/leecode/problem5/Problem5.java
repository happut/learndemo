package com.github.happut.learndemospringboot.leecode.problem5;

public class Problem5 {
    public static void main(String[] args) {
        String s = "abcdaaabbbcc";
        String s1 = "";

        System.out.println(s.charAt(s.length() - 1));
        for (int i = s.length() - 1; i != 0; i--) {
            s1 += s.charAt(i);
        }

        String test = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                test = s.substring(i,j);
            }
        }

    }
}
