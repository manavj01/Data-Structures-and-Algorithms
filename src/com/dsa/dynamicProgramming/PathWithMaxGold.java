package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class PathWithMaxGold {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];


        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + arr[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + arr[i][j];
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j + 1], dp[i][j + 1]), dp[i + 1][j + 1]) + arr[i][j];

                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0, j = 0; i < n; i++) {
            if (dp[i][j] >= max) {
                max = dp[i][j];
            }
        }
        System.out.println(max);

    }
}
