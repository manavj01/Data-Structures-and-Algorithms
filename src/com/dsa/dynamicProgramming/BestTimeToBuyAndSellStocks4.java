package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStocks4 {
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
        int obsp = -prices[0], ossp = 0, ocsp = 0;

        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0, nssp = 0, ncsp = 0;

            if (ocsp - prices[i] > obsp) {
                nbsp = ocsp - prices[i];
            } else {
                nbsp = obsp;
            }
            if (obsp + prices[i] > ossp) {
                nssp = obsp + prices[i];
            } else {
                nssp = ossp;
            }
            if (ossp > ocsp) {
                ncsp = ossp;
            } else {
                ncsp = ocsp;
            }
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;

        }
        return ossp;
    }
}