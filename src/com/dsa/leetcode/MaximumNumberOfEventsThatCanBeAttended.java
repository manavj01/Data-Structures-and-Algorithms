package com.dsa.leetcode;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        int[][] events = new int[][]{
                {1, 2}, {2, 3}, {3, 4}
        };
        System.out.println(maxEvents(events));
    }

    public static int maxEvents(int[][] events) {
        int c = 0;

        String str = "abcd";

        for (int i = 0, j = str.length() - 1; i < str.length(); i++) {
            str = str.replace(str.charAt(i), str.charAt(j));
            j--;
        }
        System.out.println(str);
        return 0;
    }
}
