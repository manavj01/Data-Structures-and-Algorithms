package com.dsa.striver30daysSheet.arrays4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        String s = "dvdf";

        System.out.println(lengthOfLongestSubstring(s));
    }
    // approach 3 O(N) - Optimal

    public static int lengthOfLongestSubstring(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        int n = str.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < n) {
            char ch = str.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }


    // approach 2 O(2*N)

    public static int lengthOfLongestSubstring1(String str) {

        if (str.length() == 0) return 0;
        if (str.length() == 1) return 1;

        int maxLen = Integer.MIN_VALUE;

        Set<Character> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < str.length(); r++) {
            if (set.contains(str.charAt(r))) {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    // approach O(N^2)
    public static int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) return 0;
        int maxLen = Integer.MIN_VALUE;


        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (set.contains(ch)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                    break;
                }
                set.add(ch);
            }
        }

        return maxLen;
    }
}
