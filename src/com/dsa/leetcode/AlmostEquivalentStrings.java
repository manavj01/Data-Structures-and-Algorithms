package com.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class AlmostEquivalentStrings {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        List<String> t = new ArrayList<>();
        s.add("aabaab");
        s.add("aaaaabb");
        t.add("bbabbc");
        t.add("abb");
        List<String> res = areAlmostEquivalent(s,t);
        System.out.println(res);
    }
    public static List<String> areAlmostEquivalent(List<String> s , List<String> t){

        List<String> res = new ArrayList<>();
        for (int i=0 ; i<s.size(); i++){
            if (checkAlmostEquivalent(s.get(i), t.get(i)).equals("Yes")){
                res.add("Yes");
            }else res.add("No");
        }
        return res;
    }
    public static String checkAlmostEquivalent(String word1, String word2) {

        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch1: word1.toCharArray()){
            map.put(ch1, map.getOrDefault(ch1,0)+1);
        }
        for(char ch2: word2.toCharArray()){
            map.put(ch2, map.getOrDefault(ch2,0)-1);
        }
        for(int i: map.values()){
            if(Math.abs(i)>3){
                return "No";
            }
        }
        return "Yes";
    }
}
