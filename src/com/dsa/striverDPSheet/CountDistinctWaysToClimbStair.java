package com.dsa.striverDPSheet;

import java.util.Arrays;

public class CountDistinctWaysToClimbStair {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Rec. - " + Recursion(n));
        System.out.println("Memo. - " + Memoization(n));
        System.out.println("Tabu. - " + Tabulation(n));
    }

    public static int Recursion(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        int ans = Recursion(n - 1) + Recursion(n - 2);


        return ans;
    }

    public static int Memoization(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        MemoizationHelper(dp, n);

        return dp[n];
    }

    public static int MemoizationHelper(int[] dp, int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        int ans = MemoizationHelper(dp, n - 1) + MemoizationHelper(dp, n - 2);
        dp[n] = ans;

        return ans;
    }

    public static int Tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] =1;
        dp[1] =1;

        for (int i=2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];
    }

}
