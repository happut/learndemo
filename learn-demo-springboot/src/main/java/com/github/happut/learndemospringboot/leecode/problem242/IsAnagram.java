package com.github.happut.learndemospringboot.leecode.problem242;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Integer,Integer> map1 = new HashMap<>();

        Map<Integer,Integer> map2 = new HashMap<>();

        s.chars().forEach(e->{
            Integer key = e-'a';
            if(map1.containsKey(key)){
                map1.put(key,map1.get(key)+1);
            }else{
                map1.put(key,1);
            }
        });

        t.chars().forEach(e->{
            Integer key = e-'a';
            if(map2.containsKey(key)){
                map2.put(key,map2.get(key)+1);
            }else{
                map2.put(key,1);
            }
        });

        for(int i=0;i<26;i++){

            Integer count1 = map1.get(i) == null?0:map1.get(i);
            Integer count2 = map2.get(i) == null?0:map2.get(i);

            if(!count1.equals(count2)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("aa","a"));
    }

}
