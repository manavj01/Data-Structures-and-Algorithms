package com.dsa.leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class RearrangeCharactersToMakeTargetString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = "abc"; //"abbaccaddaeea"; //"iloveleetcodingdoc";//scn.next();
        String target = "abcd"; //"aaaaab";//"code";//scn.next();
        int ans = rearrangeCharacters(s, target);
        System.out.println(ans);
    }

    public static int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> fmap = getMap(s);
        HashMap<Character, Integer> tmap = getMap(target);
        int min = Integer.MAX_VALUE;
        for (char ch : target.toCharArray()) {
            if (!fmap.containsKey(ch)){
                return 0;
            }
            min = Math.min(min, fmap.get(ch) / tmap.get(ch));
        }
        return min;
    }

    public static HashMap<Character, Integer> getMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        return map;
    }
}
//method 2

//    public int rearrangeCharacters(String s, String target)
//    {
//        int[] freq = new int[26], freq2 = new int[26];
//        for(char ch : s.toCharArray())
//            freq[ch-'a']++;
//        for(char ch : target.toCharArray())
//            freq2[ch-'a']++;
//
//        int min = Integer.MAX_VALUE;
//        for(char ch : target.toCharArray())
//            min = Math.min(min,freq[ch-'a']/freq2[ch-'a']);
//
//        return min;
//    }

