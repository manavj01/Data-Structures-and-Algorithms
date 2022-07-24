package com.dsa.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class BestPokerHand {
    public static void main(String[] args) {
//        int[] ranks = new int[]{12, 2, 3, 1, 9};
//        char[] suits = new char[]{'a', 'a', 'a', 'a', 'a'};
//        int[] ranks = new int[]{4,4,2,4,4};
//        char[] suits = new char[]{'d', 'a', 'a', 'b', 'c'};
        int[] ranks = new int[]{10, 10, 2, 12, 9};
        char[] suits = new char[]{'a', 'b', 'c', 'a', 'd'};
        System.out.println(bestHand(ranks, suits));
    }

    public static String bestHand(int[] ranks, char[] suits) {
//        HashMap<Integer, Character> hm = new HashMap<>();
        int n = ranks.length;
        int a = 0, b = 0, c = 0, d = 0;
        int[] freq = new int[14];
        for (int i = 0; i < ranks.length; i++) {
            if (suits[i] == 'a') {
                a++;
            } else if (suits[i] == 'b') {
                b++;
            } else if (suits[i] == 'c') {
                c++;
            } else {
                d++;
            }
            freq[ranks[i]]++;
//            hm.put(ranks[i], suits[i]);
        }
        if (a == n || b== n || c == n || d == n){
            return "Flush";
        }
        for (int i=1; i < freq.length; i++){
            if (freq[i]>=3){
                return "Three of a Kind";
            }
        }
        for (int i=1; i < freq.length; i++){
            if (freq[i] == 2){
                return "Pair";
            }
        }

        return "High Card";
    }
}
