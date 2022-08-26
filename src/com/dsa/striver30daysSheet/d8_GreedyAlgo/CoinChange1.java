package com.dsa.striver30daysSheet.d8_GreedyAlgo;

import java.util.Arrays;

public class CoinChange1 {
    public static void main(String[] args) {
        int V = 11;
        int M = 4;
//        int[] coins = {25, 10, 5};
        int[] coins = {9, 6, 5, 1};
        System.out.println(minCoins(coins, M, V));
    }

    public static int minCoins(int[] coins, int N, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < N; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount];
    }

}
