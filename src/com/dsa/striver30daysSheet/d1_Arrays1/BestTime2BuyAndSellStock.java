package com.dsa.striver30daysSheet.d1_Arrays1;

public class BestTime2BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int a : prices) {
            if (a < min) {
                min = a;
            }
            profit = Math.max(profit, a - min);
        }
        return profit;
    }
}
