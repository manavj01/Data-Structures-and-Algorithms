package com.dsa.striver30daysSheet.d15_String;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        ["deflower","flow","flight"]
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix1(String[] strs) {
        StringBuilder sb = new StringBuilder();
//        Arrays.sort(strs, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strs));
        int minLen = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minIdx = i;
            }
        }
        for (int i = 0; i < minLen; i++) {
            char ch = strs[minIdx].charAt(i);
            for (String str : strs) {
                if (ch != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }

        return sb.toString();

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
