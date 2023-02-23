package com.dsa.striverDPSheet;

import java.util.Arrays;

public class FrogJumps {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = new int[]{10, 20, 30, 10};
        System.out.println(frogJump(n, heights));
    }

    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, dp);
    }

    public static int solve(int n, int[] heights, int[] dp) {

        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int left = solve(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = solve(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }

        return dp[n] = Math.min(left, right);
    }
}
