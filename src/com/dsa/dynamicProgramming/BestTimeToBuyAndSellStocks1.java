package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStocks1 {
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
        int lsf = Integer.MAX_VALUE;
        int op = 0, pist = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if (pist > op) {
                op = pist;
            }
        }
        return op;
    }

}
