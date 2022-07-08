package com.dsa.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CountOccurrenceOfAnagrams {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String txt = "aabaabaa"; //"cbaebabacd";
        String pat = "aaba"; //"abc";
        System.out.println(search(txt, pat));
    }

    public static int search(String txt, String pat) {
        int[] orig = new int[26];
        int[] anagram = new int[26];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < pat.length(); i++) {
            orig[pat.charAt(i) - 'a']++;
        }

        int k = pat.length();
        int j = 0, i = 0, anaCount = 0;

        while (j < txt.length()) {
            anagram[txt.charAt(j) - 'a']++;

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (Arrays.equals(orig, anagram)) {
                    anaCount++;
                    arr.add(i);
                }
                anagram[txt.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }

        System.out.println(arr);
        return anaCount;
    }
}
