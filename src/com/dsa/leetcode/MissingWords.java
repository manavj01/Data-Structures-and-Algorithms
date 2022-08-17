package com.dsa.leetcode;

import java.util.*;

public class MissingWords {
    public static void main(String[] args) {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";
        System.out.println(Arrays.toString(missingWord(s, t)));
    }

    public static String[] missingWord(String s1, String s2) {
        TreeMap<String, Integer> map1 = new TreeMap<>();

        for (String s : s1.split(" ")) {
            if (!map1.containsKey(s)) {
                map1.put(s, 1);
            } else {
                map1.put(s, map1.get(s) + 1);
            }
        }
        for (String s : s2.split(" ")) {
            if (!map1.containsKey(s)) {
                map1.put(s, 1);
            } else {
                map1.put(s, map1.get(s) + 1);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (String s : map1.keySet()) {
            if (map1.get(s) == 1) {
                res.add(s);
            }
        }
        return res.toArray(new String[0]);

    }
}
