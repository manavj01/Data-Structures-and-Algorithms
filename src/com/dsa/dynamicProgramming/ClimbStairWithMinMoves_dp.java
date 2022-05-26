package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class ClimbStairWithMinMoves_dp {
    // Integer i = 5 -> stack will store address of 5
    // int ii = 5 -> stack will store 5
    // Integer[] -> empty places will store null
    // int[] -> empty places will store 0
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);

    }
}
