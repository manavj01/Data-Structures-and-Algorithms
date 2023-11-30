package com.dsa.dp_Striver;

import java.util.Arrays;

public class climbStairs {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(climbStair(n));
    }
    public static int climbStair(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        solve(n, dp);
        return dp[n];
    }

    public static int solve(int n, int[] dp) {

        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        int a = solve(n - 1, dp);
        int b = solve(n - 2, dp);

        return dp[n] = a + b;
    }
}
