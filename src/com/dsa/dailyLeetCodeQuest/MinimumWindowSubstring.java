package com.dsa.dailyLeetCodeQuest;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int length = s.length();
        int left = 0, right = 0, ansLeft = 0, ansRight = 0;

        int counter = t.length();

        int min = Integer.MAX_VALUE;

        while(right < length){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                if(map.get(ch)> 0){
                    counter--;
                }
                map.put(ch, map.getOrDefault(ch,0)-1);
            }

            while(counter == 0 && left <= right){
                if(right-left+1 < min){
                    ansLeft = left;
                    ansRight = right;
                    min = right-left+1;
                }
                if(left == right) break;

                ch = s.charAt(left);

                if(map.containsKey(ch)){
                    map.put(ch, map.getOrDefault(ch,0)+1);

                    if(map.get(ch) > 0){
                        counter++;
                    }
                }
                left++;
            }
            right++;
        }


        return min == Integer.MAX_VALUE ? "" : s.substring(ansLeft,ansRight+1);
    }
}
