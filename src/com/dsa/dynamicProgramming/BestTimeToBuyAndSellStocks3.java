package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStocks3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0];
        int ossp = 0;

        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0;
            int nssp = 0;

            if (ossp - prices[i] > obsp) {
                nbsp = ossp - prices[i];
            } else {
                nbsp = obsp;
            }
            if (obsp + prices[i] - fee > ossp) {
                nssp = obsp + prices[i] - fee;
            } else {
                nssp = ossp;
            }
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
}
