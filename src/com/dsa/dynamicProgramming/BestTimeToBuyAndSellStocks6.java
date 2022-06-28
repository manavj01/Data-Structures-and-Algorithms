package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStocks6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

//        System.out.println(maxProfit(prices));
    }

//    public static int maxProfit(int[] prices) {
//
//    }
}
