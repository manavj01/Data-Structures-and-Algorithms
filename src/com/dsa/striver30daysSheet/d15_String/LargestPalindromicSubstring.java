package com.dsa.striver30daysSheet.d15_String;

public class LargestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    static class Pair {
        int end_idx;
        int size;

        Pair(int end_idx, int size) {
            this.end_idx = end_idx;
            this.size = size;
        }
    }

    public static String longestPalindrome(String s) {

        int n = s.length();
        String res = "";
        Pair[] dp = new Pair[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
//                    if ()
                }
            }
        }

        return "";
    }

    public static boolean isPalindrome(String str) {
        return true;
    }
}

