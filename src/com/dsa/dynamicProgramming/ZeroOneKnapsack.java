package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];

        for (int i = 0; i < vals.length; i++) {
            vals[i] = scn.nextInt();
        }
        for (int i = 0; i < wts.length; i++) {
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j]; // when i doesnt bat
                if (j >= wts[i - 1]) {
                    int rCap = j - wts[i - 1];
                    if (dp[i - 1][rCap] + vals[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rCap] + vals[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j]; // when i doesnt bat
                    }
                } else {
                    dp[i][j] = dp[i - 1][j]; // when i doesnt bat
                }
            }
        }
        System.out.println(dp[n][cap]);
    }

}
