package com.dsa.striverDPSheet;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 8;
        System.out.println("recursion ans " + recursion(n));
        System.out.println("dp Memo. " + dpMemFib(n));
        System.out.println("dp Tabu.  " + dpTabFib(n));
    }

    public static int recursion(int n) {
        if (n <= 1) {
            return n;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    public static int dpMemFib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dpFibHelper(n, dp);
        return dp[n];
    }

    public static int dpFibHelper(int n, int[] dp) {

        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = dpFibHelper(n - 1, dp) + dpFibHelper(n - 2, dp);
        dp[n] = ans;
        return ans;
    }

    public static int dpTabFib(int n) {
        int[] dp = new int[n+1];
        dp[0] =0;
        dp[1] =1;

        for (int i=2; i<= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
