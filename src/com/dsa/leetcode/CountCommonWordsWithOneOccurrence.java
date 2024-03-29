package com.dsa.leetcode;

import java.util.*;

public class CountCommonWordsWithOneOccurrence {
    public static void main(String[] args) {
        System.out.println(countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"}));
    }
    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (String s : words1) {
            if (!map1.containsKey(s)) {
                map1.put(s, 1);
            } else map1.put(s, map1.get(s) + 1);
        }
        for (String s : words2) {
            if (!map2.containsKey(s)) {
                map2.put(s, 1);
            } else map2.put(s, map2.get(s) + 1);
        }
        int c = 0;

        for (String s : map1.keySet()) {
            if (map1.get(s) == 1) {
                if (map2.get(s) != null) {
                    if (map2.get(s) == 1) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
}
