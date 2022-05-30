package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class CoinChangeCombination_dp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = scn.nextInt();
        }
        int amount = scn.nextInt();

        CoinChangeCombination_dp obj = new CoinChangeCombination_dp();
        int res = obj.coinChange(coins, amount);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        if (dp[amount] == 0) {
            return -1;
        } else {
            int ans = dp[amount];
            return ans;
        }
    }
}
