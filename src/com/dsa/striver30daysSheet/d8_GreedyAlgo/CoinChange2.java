package com.dsa.striver30daysSheet.d8_GreedyAlgo;

public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j < dp.length; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
