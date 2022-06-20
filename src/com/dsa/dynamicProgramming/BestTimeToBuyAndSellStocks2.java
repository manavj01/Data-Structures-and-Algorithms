package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStocks2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int bd = 0;
        int sd = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sd++;
            } else {
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        profit += prices[sd] - prices[bd];
        return profit;
    }
}
