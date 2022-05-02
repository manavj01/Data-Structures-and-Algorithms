package com.dsa.leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class CountPrefixesOfAGivenString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "vomy";
        String[] words = {"ycwj", "hak", "v", "kjg", "zw", "vtes", "vom", "ii", "as", "v", "vo", "v", "w", "vomy", "loa", "fbm", "j", "v", "vo", "e", "y", "t", "eh", "yk", "bt", "x", "vomy", "vom", "yab", "v", "sydi", "wnb", "z", "v", "iygp", "vomy"};
//        String s = "w";
//        String[] words = new String[]{"feh","w","w","lwd","c","s","vk","zwlv","n","w","sw","qrd","w","w","mqe","w","w","w","gb","w","qy","xs","br","w","rypg","wh","g","w","w","fh","w","w","sccy"};
        int prefix = countPrefixes(words, s);
        System.out.println(prefix);
    }

    public static int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String str : words) {
            if (str.length() > s.length()) continue;
            int flag = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != s.charAt(i)) {
                    flag = -1;
                    break;
                }
            }
            if(flag == 1) count++;
        }
        return count;
    }

    public static int countPrefixes2(String[] words, String s) {
//        char[] strarray = s.toCharArray();
        int count = 0;

        for (String str : words) {
//            if(s.length() >= str.length()) {
            if (str.substring(0, s.length()).equals(s)) {
                count++;
            }
//            } else {
//                char[] strarray = s.toCharArray();
//
//            }
        }
        return count;
    }
}

// feh w w lwd c s vk zwlv n w sw qrd w w mqe w w w gb w qy xs br w rypg wh g w w fh w w sccy
// vomy